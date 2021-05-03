package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateInstructorDemo {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
	
		//create session
		Session session = factory.getCurrentSession();
		
		//insert in to database using save()
		try {
			Instructor tempInstructor= new Instructor("fname-15", "lname15","15@mail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.15.com","hobby1");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			//save the  object
			session.save(tempInstructor);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("commited.............");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
