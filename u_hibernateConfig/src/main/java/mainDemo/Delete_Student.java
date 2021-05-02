package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Delete_Student {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session; 

		try {
			// get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//option-1
			//Student s1= session.get(Student.class, 3); //get student with id=1
			//session.delete(s1);
			
			//option-2
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			System.out.println("student deleted");
			
			//commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
