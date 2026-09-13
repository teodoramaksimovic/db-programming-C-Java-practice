package zadatak_11_1;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;
class Main {
    public static void main(String[] args) {
        Session s=HibernateUtil.getSessionFactory().openSession(); Transaction tr=null;
        try {
            tr=s.beginTransaction();
            Query<IspitniRok> q=s.createQuery("FROM IspitniRok ORDER BY id.skGodina, id.oznakaRoka",IspitniRok.class);
            List<IspitniRok> rokovi=q.list();
            for(IspitniRok r:rokovi) System.out.println(r);
            tr.commit();
        } catch(Exception e) { if(tr!=null) tr.rollback(); e.printStackTrace(); }
        finally { s.close(); HibernateUtil.getSessionFactory().close(); }
    }
}
