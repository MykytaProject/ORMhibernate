package ad.orm.hibernate.app;

import java.util.Iterator;
import java.util.List;
import ad.orm.hibernate.domain.*;
import ad.orm.hibernate.util.MiSesion;

import org.hibernate.*;

public class App {

  public static void main(String[] args) {

    SessionFactory sf = MiSesion.getSessionFactory();
    Session s = sf.openSession();

    s.close();
    MiSesion.close(sf);
  }
}
