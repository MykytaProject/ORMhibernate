package ad.orm.hibernate.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MiSesion {

    private MiSesion() {
    }

    private static final SessionFactory sf = getConexion();

    private static SessionFactory getConexion() {
        SessionFactory sf = null;
        try {
            // Crea la SessionFactory desde el fichero hibernate.cfg.xml
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            System.out.println("Se ha cargado la configuración");
            sf = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sf;
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    public static void close(SessionFactory sf) {
        sf.close();
    }
}
