package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Update_Student {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session; 

		try {
			// get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//option -1
			//session.createQuery("update Student set email='foo@gmail.com' where id=1").executeUpdate();
			
			//option-2
			Student s1= session.get(Student.class, 1); //get student with id=1
			s1.setEmail("hello@gmail.com");
			System.out.println("student details updated");
			
			//commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
