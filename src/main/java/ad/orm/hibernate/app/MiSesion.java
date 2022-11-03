package ad.orm.hibernate.app;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();
            sf = config.buildSessionFactory(serviceRegistry);
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
