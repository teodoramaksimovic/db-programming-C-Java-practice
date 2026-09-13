package zadatak_11_5;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        readPredmetiIStudenti();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void readPredmetiIStudenti() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction TR = null;

        try (Scanner ulaz = new Scanner(System.in)) {
            TR = session.beginTransaction();

            System.out.println("Unesite skolsku godinu:");
            Integer skGodina = ulaz.nextInt();

            String hql = "FROM Predmet";
            Query<Predmet> upit = session.createQuery(hql, Predmet.class);
            List<Predmet> predmeti =
                    Collections.checkedList(upit.list(), Predmet.class);

            hql = "FROM UpisanKurs uk " +
                  "WHERE uk.predmet.id = :id AND uk.id.skGodina = :skGodina " +
                  "ORDER BY uk.student.prezime, uk.student.ime";
            Query<UpisanKurs> upit2 = session.createQuery(hql, UpisanKurs.class);

            for (Predmet predmet : predmeti) {
                System.out.println("\nPREDMET: " + predmet.getOznaka().trim() +
                        " - " + predmet.getNaziv().trim());

                upit2.setParameter("id", predmet.getId());
                upit2.setParameter("skGodina", skGodina);

                List<UpisanKurs> upisani =
                        Collections.checkedList(upit2.list(), UpisanKurs.class);

                for (UpisanKurs uk : upisani) {
                    Student student = uk.getStudent();
                    System.out.println("Student: " + student.getIndeks() + ", " +
                            student.getPrezime().trim() + ", " + student.getIme().trim());
                }
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Postoji problem sa izlistavanjem studenata po predmetima! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
