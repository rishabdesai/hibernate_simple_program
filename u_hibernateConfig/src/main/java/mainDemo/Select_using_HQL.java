package mainDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Select_using_HQL {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
	
		try {
			//begin transaction
			session.beginTransaction();
			
			//query using HQL
			List<Student> allStudents = session.createQuery("from Student").getResultList();
			
			//display the result
			for(Student s: allStudents)
				System.out.println(s);
			
			//commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
