package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class CreateDemo_uni {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
	
		//create session
		Session session = factory.getCurrentSession();
		
		//insert in to database using save()
		try {
			Instructor tempInstructor= new Instructor("fname-12", "lname12","12@mail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.12.com","hobby12");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			//save the  object
			session.save(tempInstructor);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("commited.............");
		} finally {
			factory.close();
		}
		
	}

}
