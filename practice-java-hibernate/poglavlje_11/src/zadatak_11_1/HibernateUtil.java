package zadatak_11_1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder().configure().build();

            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(IspitniRok.class);
            sessionFactory = sources.buildMetadata().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Greska pri kreiranju SessionFactory.");
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
