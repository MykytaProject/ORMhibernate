package ad.orm.hibernate.app;
import java.util.List;
import org.hibernate.*;
import ad.orm.hibernate.domain.Clase;
public class App {

  public static void main(String[] args) {
     Session s = MiSesion.getSessionFactory().openSession();
    Clase c = new Clase();
    c.setNombre("alumno");
    Transaction tx = s.beginTransaction();
    s.persist(c);
    tx.commit();


    try {
      // Creamos objeto de tipo Clase
      @SuppressWarnings("all")
      List<Object> clase = s
          .createNativeQuery("SELECT * FROM CLASE")
          .addScalar("NOMBRE")
          .list();
      for (Object i : clase) {
        System.out.println("Nombre de la Clase: " + (String) i);
      }

    } catch (Exception e) {
    } finally {
      s.close();
    }
  }
}
