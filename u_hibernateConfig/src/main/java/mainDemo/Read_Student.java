package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Read_Student {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session; 

		try {
			// get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrive student based on ID
			Student student = session.get(Student.class, 1);
			System.out.println("student details :  " + student);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
