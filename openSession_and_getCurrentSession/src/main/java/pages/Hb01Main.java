package pages;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hb01Main {

	public static void main(String[] args) {

		
		//difference between openSession() and getCurrentSession() 
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Session session1 = factory.getCurrentSession();
		Session session2 = factory.getCurrentSession();
		System.out.println("Is Same Session : " + (session1==session2)); //true
		
		Session session3 = factory.openSession();
		Session session4 = factory.openSession();
		System.out.println("Is Same Session : " + (session3==session4)); //false
		session3.close();
		session4.close();
		
		factory.close();
	
	}
}