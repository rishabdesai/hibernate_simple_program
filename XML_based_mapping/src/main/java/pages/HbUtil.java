package pages;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// to create SessionFactory
//one SessionFactory per application (per database)
public class HbUtil {
	 
	private static SessionFactory factory = createSessionFactory();
	
	//create a method which returns a SessionFactory
	private static SessionFactory createSessionFactory() {
		Configuration cfg = new Configuration(); // blank  configuration object
		cfg.configure(); // read hibernate.cfg.xml
		return cfg.buildSessionFactory(); // create factory
	}
	
	//to access the SessionFactory outside
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	
	//create new session
	public static Session openSession() {
		return factory.openSession();
	}
	
	//close the session
	public static void shutdown() {
		if(factory!=null)
			factory.close();
	}
}
