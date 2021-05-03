package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class Get_Instructor_uni {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// insert in to database using save()
		try {
			// start a transaction
			session.beginTransaction();

			Instructor theInstructor = session.get(Instructor.class, 11);
			
			System.out.println("the instructor   :  " + theInstructor.getId());
			System.out.println("the  instructor   :  " + theInstructor.getFirst_name());
			System.out.println("the  instructor   :  " + theInstructor.getLast_name());
			System.out.println("the  instructor   :  " + theInstructor.getEmail());
			
			System.out.println(" instructor details   :  " + theInstructor.getInstructorDetail().getHobby());
			System.out.println(" instructor details   :  " + theInstructor.getInstructorDetail().getYoutube_channel());

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
