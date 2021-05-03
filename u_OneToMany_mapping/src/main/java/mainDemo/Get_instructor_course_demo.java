package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class Get_instructor_course_demo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// insert in to database using save()
		try {
			// start a transaction
			session.beginTransaction();

			Instructor tempInstructor = session.get(Instructor.class,13);
			
			System.out.println("name of instructor is : "+tempInstructor);
			
			System.out.println("courses : "+tempInstructor.getCourses() );
			
			// commit transaction
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
