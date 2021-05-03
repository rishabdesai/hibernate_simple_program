package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class DeleteDemo_bidirectional {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
	
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			InstructorDetail tempInstructor= session.get(InstructorDetail.class, 12);
			session.delete(tempInstructor);

			//commit transaction
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
