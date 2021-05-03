package mainDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class Get_Instructor_Bidirectional {

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

			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, 11);
			System.out.println(" instructor details   :  " + theInstructorDetail.getHobby());
			System.out.println(" instructor details   :  " + theInstructorDetail.getYoutube_channel());
			
			System.out.println("the associated instructor   :  " + theInstructorDetail.getInstructor().getId());
			System.out.println("the associated instructor   :  " + theInstructorDetail.getInstructor().getFirst_name());
			System.out.println("the associated instructor   :  " + theInstructorDetail.getInstructor().getLast_name());
			System.out.println("the associated instructor   :  " + theInstructorDetail.getInstructor().getEmail());

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
