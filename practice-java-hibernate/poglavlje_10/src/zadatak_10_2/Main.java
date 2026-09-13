package zadatak_10_2;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        insertIspitniRok();
        readIspitniRok();
        deleteIspitniRok();
        readIspitniRok();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void insertIspitniRok() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        IspitniRokId id = new IspitniRokId(2020, "jun");
        IspitniRok ispitniRok = new IspitniRok(
                id,
                "Junski ispitni rok",
                Date.valueOf("2020-06-01"),
                Date.valueOf("2020-06-30"));

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.save(ispitniRok);

            System.out.println("Ispitni rok je sacuvan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Cuvanje ispitnog roka nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void readIspitniRok() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            IspitniRokId id = new IspitniRokId(2020, "jun");
            IspitniRok ispitniRok = session.get(IspitniRok.class, id);

            if (ispitniRok != null) {
                System.out.println(ispitniRok);
            } else {
                System.out.println("Ispitni rok ne postoji.");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Citanje ispitnog roka nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void deleteIspitniRok() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            IspitniRokId id = new IspitniRokId(2020, "jun");
            IspitniRok ispitniRok = session.get(IspitniRok.class, id);

            if (ispitniRok != null) {
                session.delete(ispitniRok);
                System.out.println("Ispitni rok je obrisan!");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Brisanje ispitnog roka nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
