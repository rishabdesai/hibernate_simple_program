package pages;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {

	public Book getBook(int id) {
		Session session = HbUtil.getSession();
		Book b = session.get(Book.class, id);
		return b;
	}

}
