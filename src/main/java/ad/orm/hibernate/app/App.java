package ad.orm.hibernate.app;

import org.hibernate.Session;

import ad.orm.hibernate.service.Menu;
import ad.orm.hibernate.util.HibernateUtil;

public class App {

  public static Session s = HibernateUtil.getSessionFactory().openSession();

  public static void main(String[] args) {

    Menu.ejecutarMenu();

    s.close();
  }
}
