package ad.orm.hibernate.app;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ad.orm.hibernate.domain.Usuario;
import ad.orm.hibernate.util.MiSesion;

public class App {

  public static void main(String[] args) {

    SessionFactory sf = MiSesion.getSessionFactory();
    Session s = sf.openSession();
    s.beginTransaction();

    Usuario niki = new Usuario();

    niki.setApellido("Ryasny");
    niki.setFecha(new GregorianCalendar(1994, 06, 03));
    niki.setNombre("Nikita");

    s.persist(niki);
    s.getTransaction().commit();
   

    s.close();
    MiSesion.close(sf);
  }
}
