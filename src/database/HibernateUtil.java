package database;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
//			Configuration configuration = new Configuration().configure();
//			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//			serviceRegistry = builder.applySettings(
//		            configuration.getProperties()).build();//.buildServiceRegistry();
////			sessionFactory = (SessionFactory) new StandardServiceRegistryBuilder().applySettings(
////		            configuration.getProperties()).build();
//			//sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			Configuration configuration = new Configuration().configure(config);
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
			    configuration.getProperties()
			).buildServiceRegistry();

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
//			Configuration configuration = new Configuration().configure();
//			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//			sessionFactory = configuration.buildSessionFactory(builder.build());
		} 
		catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}