package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import entity.Student;

public class Main {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
	
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {
			System.out.println("Creating new student object");
			//create student object
			Student s1 = new Student("ram", "kumar", "ram@mail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student...");
			session.save(s1);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("commited.............");
		} finally {
			factory.close();
		}
		
	}

}
