package pages;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hb01Main {

	public static void main(String[] args) {

		// load() method
//		try (Session session = HbUtil.openSession()) {
//			Book b1 = session.load(Book.class, 42);
//			System.out.println("Book id : " + b1.getId()); // Book id : 42
//			System.out.println("Returned : " + b1.getClass().getName()); // Returned :pages.Book$HibernateProxy$fLvEIxvF
//			System.out.println("Book name : " + b1.getTitle()); // Book name : DESIGN OF UNIX OS
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		// evict() demo
//		Transaction tx = null;
//		try(Session session = HbUtil.openSession()) {
//			tx = session.beginTransaction();
//			Book b = session.get(Book.class, 11);
//			session.evict(b); // remove obj from session cache manually
//			b.setCost(263.21);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
		
//		// update() demo
//		Transaction tx = null;
//		try(Session session = HbUtil.openSession()) {
//			tx = session.beginTransaction();
//			Book b = session.get(Book.class, 11);
//			session.evict(b); // remove obj from session cache manually
//			b.setCost(263.21);
//			session.update(b); // update the obj into db -- add obj into cache with flag=true
//			tx.commit();
//		} catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
		
//		//persist() method
//		Transaction tx = null;
//		try(Session session = HbUtil.openSession()) {
//			tx = session.beginTransaction();
//			Book b = new Book(51, "The Fountainhead", "Any Rand", "Novell", 723.23);
//			//session.persist(b); // try to INSERT & fail due to PK
//			session.update(b);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
		
//		//merge() method called on object with existing primary key
//		Transaction tx = null;
//		try(Session session = HbUtil.openSession()) {
//			tx = session.beginTransaction();
//			Book b = new Book(51, "The Alchemist", "Paulo Coelo", "Novell", 723);
//			session.merge(b);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
		
		
		// merge() - if id=52 do not exists, hence first SELECT query fire, 
		//then If id exists then UPDATE query fire else INSERT query fire.
		Transaction tx = null;
		try(Session session = HbUtil.openSession()) {
			tx = session.beginTransaction();
			Book b = new Book(52, "Harry Potter", "Rowling", "Novell", 232.45);
			session.merge(b);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}

		HbUtil.shutdown();
	}

}
