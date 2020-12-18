package duolingo.lib.hibernate.util;

import java.util.Properties;

import duolingo.lib.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://ip:puerto/nombreBaseDatos?serverTimezone=UTC");
                settings.put(Environment.USER, "user");
                settings.put(Environment.PASS, "password");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);
                
                	
                configuration.addAnnotatedClass(UsersModel.class);
                configuration.addAnnotatedClass(LeagueModel.class);
                configuration.addAnnotatedClass(ShopItemsModel.class);
                configuration.addAnnotatedClass(AvtModel.class);   
                configuration.addAnnotatedClass(CrsModel.class);
                configuration.addAnnotatedClass(CatModel.class);
                configuration.addAnnotatedClass(LangModel.class);
                configuration.addAnnotatedClass(LvlModel.class);
                configuration.addAnnotatedClass(ExsModel.class);   

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
