package zadatak_11_6;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        readStudijskiProgramiINajmladjiStudenti();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void readStudijskiProgramiINajmladjiStudenti() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction TR = null;

        try {
            TR = session.beginTransaction();

            Date granica = Date.valueOf(LocalDate.now().minusYears(10));

            // Pronalazimo programe koje je u poslednjih 10 godina upisalo vise od 30 studenata.
            String hql =
                    "SELECT s.studijskiProgram " +
                    "FROM Student s " +
                    "WHERE s.datumUpisa >= :granica " +
                    "GROUP BY s.studijskiProgram " +
                    "HAVING COUNT(s) > 30 " +
                    "ORDER BY s.studijskiProgram.Naziv";

            Query<StudijskiProgram> upit =
                    session.createQuery(hql, StudijskiProgram.class);
            upit.setParameter("granica", granica);

            List<StudijskiProgram> programi =
                    Collections.checkedList(upit.list(), StudijskiProgram.class);

            // U dostavljenoj semi ne postoji datum rodjenja.
            // Zato najmladjeg tumacimo kao studenta sa najskorijim datumom upisa.
            String hql2 =
                    "FROM Student s " +
                    "WHERE s.idPrograma = :id AND s.datumUpisa >= :granica " +
                    "ORDER BY s.datumUpisa DESC, s.indeks DESC";

            Query<Student> upit2 = session.createQuery(hql2, Student.class);
            upit2.setMaxResults(1);

            for (StudijskiProgram program : programi) {
                upit2.setParameter("id", program.getId());
                upit2.setParameter("granica", granica);

                List<Student> studenti =
                        Collections.checkedList(upit2.list(), Student.class);

                if (studenti.size() == 0)
                    continue;

                Student student = studenti.get(0);

                System.out.printf("%s | %d | %s %s | %s | %d | %.2f%n",
                        program.getNaziv().trim(),
                        student.getIndeks(),
                        student.getIme().trim(),
                        student.getPrezime().trim(),
                        student.getDatumUpisa(),
                        student.brojPolozenih(),
                        student.prosek());
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Postoji problem sa izdvajanjem podataka! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
