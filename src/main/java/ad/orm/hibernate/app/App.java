package ad.orm.hibernate.app;

import org.hibernate.*;

public class App {

  public static void main(String[] args) {
    SessionFactory sf = MiSesion.getSessionFactory();

    MiSesion.close(sf);
  }
}
