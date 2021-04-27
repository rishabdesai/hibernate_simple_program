package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
	private static final SessionFactory factory = createSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory createSessionFactory() {
		serviceRegistry = new StandardServiceRegistryBuilder()
				.configure() // read from hibernate.cfg.xml
				.build();
	
		Metadata metadata = new MetadataSources(serviceRegistry)
				//.addPackage("com.sunbeaminfo.sh.pizza.entities")
				.getMetadataBuilder()
				.build();
		
		return metadata.getSessionFactoryBuilder().build();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static Session getSession() {
		return factory.getCurrentSession();
	}
	public static void beginTransaction() {
		factory.getCurrentSession()
			.getTransaction().begin();
	}
	public static void commitTransaction() {
		factory.getCurrentSession()
			.getTransaction().commit();
	}
	public static void rollbackTransaction() {
		factory.getCurrentSession()
			.getTransaction().rollback();
	}
	public static void shutdown() {
		factory.close();
	}
}
