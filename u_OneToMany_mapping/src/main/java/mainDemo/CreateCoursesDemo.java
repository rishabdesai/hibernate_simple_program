package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateCoursesDemo {
	
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
			//start a transaction
			session.beginTransaction();
			
			//get the instructor from database
			Instructor tempInstructor = session.get(Instructor.class, 13);  
			
			//create some courses
			Course tempCourse1 = new Course("Cpp");
			Course tempCourse2 = new Course("Java");
			
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("commited.............");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
