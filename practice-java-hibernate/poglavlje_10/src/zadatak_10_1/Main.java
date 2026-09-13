package zadatak_10_1;

import org.hibernate.Session;
import org.hibernate.Transaction;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        insertStudijskiProgram();
        readStudijskiProgram();
        updateStudijskiProgram();
        readStudijskiProgram();
        deleteStudijskiProgram();
        readStudijskiProgram();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void insertStudijskiProgram() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        StudijskiProgram studijskiProgram = new StudijskiProgram(
                102,
                "MATF_2020",
                "Novi MATF studijski program u 2020. godini",
                240,
                1,
                "Diplomirani informaticar",
                "Novi MATF studijski program na Matematickom fakultetu");

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.save(studijskiProgram);

            System.out.println("Studijski program je sacuvan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Cuvanje studijskog programa nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void readStudijskiProgram() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            StudijskiProgram studijskiProgram =
                    session.get(StudijskiProgram.class, 102);

            if (studijskiProgram != null) {
                System.out.println(studijskiProgram);
            } else {
                System.out.println("Studijski program sa identifikatorom 102 ne postoji.");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Citanje studijskog programa nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void updateStudijskiProgram() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            StudijskiProgram studijskiProgram =
                    session.get(StudijskiProgram.class, 102);

            if (studijskiProgram != null) {
                studijskiProgram.setNaziv("Izmenjeni MATF studijski program");
                session.update(studijskiProgram);
                System.out.println("Studijski program je izmenjen!");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Azuriranje studijskog programa nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void deleteStudijskiProgram() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        StudijskiProgram studijskiProgram = new StudijskiProgram();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.load(studijskiProgram, 102);
            session.delete(studijskiProgram);

            System.out.println("Studijski program je obrisan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Brisanje studijskog programa nije uspelo! Ponistavanje transakcije!");

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
