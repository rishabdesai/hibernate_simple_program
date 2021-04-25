package pages;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao implements AutoCloseable {
	//get reference of Session
	private Session session;
	//method to open session
	public void open() {
		session = HbUtil.openSession();
	}
	
	//method to close the session
	@Override
	public void close() {
		if(session != null)
			session.close();
	}
	
	//SEARCH - method to get book by ID
	public Book getBook(int id) {
		Book b = session.get(Book.class, id);
		return b;
	}
	
	//INSERT 
	public void addBook(Book b) {
		Transaction tx = session.beginTransaction();
		try {
			session.persist(b);
			tx.commit();   
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	//UPDATE 
	public void updateBook(Book b) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(b);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	//DELETE 
	public void deleteBook(int id) {
		Transaction tx = session.beginTransaction();
		try {
			Book b = session.get(Book.class, 99);
			if(b != null)
				session.remove(b);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
