package zadatak_11_3;
import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;
class Main {
 public static void main(String[] args) {
  Session s=HibernateUtil.getSessionFactory().openSession(); Transaction tr=null;
  try {
   tr=s.beginTransaction();
   List<StudijskiProgram> programi=s.createQuery("FROM StudijskiProgram ORDER BY naziv",StudijskiProgram.class).list();
   Query<Object[]> q=s.createQuery(
      "SELECT st.indeks, st.ime, st.prezime, AVG(i.ocena) "+
      "FROM Student st LEFT JOIN Ispit i ON i.student = st AND i.ocena >= 6 "+
      "WHERE st.idPrograma = :id "+
      "GROUP BY st.indeks, st.ime, st.prezime ORDER BY st.prezime, st.ime", Object[].class);
   for(StudijskiProgram sp:programi) {
    System.out.println("\nSTUDIJSKI PROGRAM: "+sp.getNaziv().trim());
    q.setParameter("id",sp.getId());
    for(Object[] r:q.list()) {
      Double prosek=(Double)r[3];
      System.out.printf("%s %s %s, prosek: %s%n",r[0],((String)r[1]).trim(),((String)r[2]).trim(),
          prosek==null ? "-" : String.format("%.2f",prosek));
    }
   }
   tr.commit();
  } catch(Exception e){if(tr!=null)tr.rollback();e.printStackTrace();}
  finally{s.close();HibernateUtil.getSessionFactory().close();}
 }
}
