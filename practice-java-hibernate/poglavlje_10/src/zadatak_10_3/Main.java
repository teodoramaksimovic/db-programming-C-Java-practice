package zadatak_10_3;

import org.hibernate.Session;
import org.hibernate.Transaction;

class Main {

    public static void main(String[] args) {
        System.out.println("Pocetak rada...\n");

        insertNivoKvalifikacije();
        readNivoKvalifikacije();
        updateNivoKvalifikacije();
        readNivoKvalifikacije();
        deleteNivoKvalifikacije();
        readNivoKvalifikacije();

        System.out.println("Zavrsetak rada.\n");
        HibernateUtil.getSessionFactory().close();
    }

    private static void insertNivoKvalifikacije() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        NivoKvalifikacije nivo = new NivoKvalifikacije(42, "Novi nivo");

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.save(nivo);

            System.out.println("Nivo kvalifikacije je sacuvan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Cuvanje nivoa kvalifikacije nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void readNivoKvalifikacije() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            NivoKvalifikacije nivo = session.get(NivoKvalifikacije.class, 42);

            if (nivo != null) {
                System.out.println(nivo);
            } else {
                System.out.println("Nivo kvalifikacije sa identifikatorom 42 ne postoji.");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Citanje nivoa kvalifikacije nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void updateNivoKvalifikacije() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            NivoKvalifikacije nivo = session.get(NivoKvalifikacije.class, 42);
            if (nivo != null) {
                nivo.setNaziv("Novi nivo kvalifikacije");
                session.update(nivo);
                System.out.println("Nivo kvalifikacije je izmenjen!");
            }

            TR.commit();
        } catch (Exception e) {
            System.err.println("Azuriranje nivoa kvalifikacije nije uspelo! Ponistavanje transakcije!");
            e.printStackTrace();

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }

    private static void deleteNivoKvalifikacije() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        NivoKvalifikacije nivo = new NivoKvalifikacije();

        Transaction TR = null;
        try {
            TR = session.beginTransaction();

            session.load(nivo, 42);
            session.delete(nivo);

            System.out.println("Nivo kvalifikacije je obrisan!");
            TR.commit();
        } catch (Exception e) {
            System.err.println("Brisanje nivoa kvalifikacije nije uspelo! Ponistavanje transakcije!");

            if (TR != null) {
                TR.rollback();
            }
        } finally {
            session.close();
        }
    }
}
