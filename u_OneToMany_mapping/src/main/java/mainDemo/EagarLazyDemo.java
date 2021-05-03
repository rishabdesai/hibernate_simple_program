package mainDemo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class EagarLazyDemo {
	
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
			
			//get the instructor from database using getter - option1
			Instructor tempInstructor = session.get(Instructor.class, 13);  
			System.out.println("### instructor   :  "+tempInstructor);
			System.out.println("### courses :  "+tempInstructor.getCourses());

			//option-2 using HQL
//			org.hibernate.query.Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id=:p_instructorId", Instructor.class);
//			 query.setParameter("p_instructorId", 13);
//			 Instructor tempIns= query.getSingleResult();
//			 System.out.println("instructor using HQL  "+tempIns);
			
			 
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("### Done.............");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
