package zadatak_10_4;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

class Main {

    private static Integer id;
    private static String oznaka;
    private static String naziv;
    private static Integer espb;

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        try (Scanner ulaz = new Scanner(System.in)) {
            System.out.println("Unesite identifikator predmeta:");
            id = ulaz.nextInt();
            ulaz.nextLine();

            System.out.println("Unesite oznaku predmeta:");
            oznaka = ulaz.nextLine();

            System.out.println("Unesite naziv predmeta:");
            naziv = ulaz.nextLine();

            System.out.println("Unesite broj ESPB bodova:");
            espb = ulaz.nextInt();

            insertPredmet();
            readPredmet();

            System.out.println("Da li zelite da izmenite broj ESPB bodova? (da/ne)");
            String odgovor = ulaz.next();

            if (odgovor.equalsIgnoreCase("da")) {
                System.out.println("Unesite novi broj ESPB bodova:");
                Integer noviEspb = ulaz.nextInt();
                updatePredmet(noviEspb);
            }

            readPredmet();
            deletePredmet();
            readPredmet();
        }

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void insertPredmet() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Predmet predmet = new Predmet(id, oznaka, naziv, espb);

        Transaction TR = null;
        try {
            TR = session.beginTransaction();
            session.save(predmet);
            System.out.println("Predmet je sacuvan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Cuvanje predmeta nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();
            if (TR != null) TR.rollback();
        } finally {
            session.close();
        }
    }

    private static void readPredmet() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            Predmet predmet = session.get(Predmet.class, id);
            if (predmet != null)
                System.out.println(predmet);
            else
                System.out.println("Predmet sa identifikatorom " + id + " ne postoji.");

            TR.commit();
        } catch (Exception e) {
            System.err.println("Citanje predmeta nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();
            if (TR != null) TR.rollback();
        } finally {
            session.close();
        }
    }

    private static void updatePredmet(Integer noviEspb) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            Predmet predmet = session.get(Predmet.class, id);
            if (predmet != null) {
                predmet.setEspb(noviEspb);
                session.update(predmet);
                System.out.println("Predmet je izmenjen!");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Azuriranje predmeta nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();
            if (TR != null) TR.rollback();
        } finally {
            session.close();
        }
    }

    private static void deletePredmet() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Predmet predmet = new Predmet();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.load(predmet, id);
            session.delete(predmet);

            System.out.println("Predmet je obrisan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Brisanje predmeta nije uspelo! Ponistavanje transakcije!");
            if (TR != null) TR.rollback();
        } finally {
            session.close();
        }
    }
}
