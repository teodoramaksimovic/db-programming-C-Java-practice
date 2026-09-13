package zadatak_11_4;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        readStudijskiProgramiIPredmeti();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void readStudijskiProgramiIPredmeti() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction TR = null;

        try {
            TR = session.beginTransaction();

            // Osnovne akademske studije imaju nivo 1.
            String hql = "FROM StudijskiProgram WHERE Nivo = 1";
            Query<StudijskiProgram> upit = session.createQuery(hql, StudijskiProgram.class);
            List<StudijskiProgram> programi =
                    Collections.checkedList(upit.list(), StudijskiProgram.class);

            hql = "FROM PredmetPrograma pp " +
                  "WHERE pp.studijskiProgram.id = :id AND lower(pp.vrsta) = 'obavezan'";
            Query<PredmetPrograma> upit2 = session.createQuery(hql, PredmetPrograma.class);

            for (StudijskiProgram program : programi) {
                System.out.println("\n" + program);

                upit2.setParameter("id", program.getId());
                List<PredmetPrograma> predmeti =
                        Collections.checkedList(upit2.list(), PredmetPrograma.class);

                for (PredmetPrograma pp : predmeti) {
                    Predmet predmet = pp.getPredmet();
                    System.out.println("Predmet: " + predmet.getOznaka().trim() + ", " +
                            predmet.getNaziv().trim() + ", " + predmet.getEspb() + " ESPB");
                }
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Postoji problem sa izlistavanjem obaveznih predmeta! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
