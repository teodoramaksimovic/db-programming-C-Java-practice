package zadatak_11_2;
import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Mesto rodjenja: "); String mesto=sc.nextLine();
        System.out.print("Obim ESPB studijskog programa: "); int espb=Integer.parseInt(sc.nextLine());

        Session s=HibernateUtil.getSessionFactory().openSession(); Transaction tr=null;
        try {
            tr=s.beginTransaction();
            String hql="FROM Student st WHERE st.mesto = :mesto AND st.studijskiProgram.espb = :espb ORDER BY st.prezime, st.ime";
            Query<Student> q=s.createQuery(hql,Student.class);
            q.setParameter("mesto",mesto); q.setParameter("espb",espb);
            for(Student st:q.list())
                System.out.println(st.getIme().trim()+" "+st.getPrezime().trim()+" - "+st.getStudijskiProgram().getNaziv().trim());
            tr.commit();
        } catch(Exception e) { if(tr!=null) tr.rollback(); e.printStackTrace(); }
        finally { s.close(); HibernateUtil.getSessionFactory().close(); }
    }
}
