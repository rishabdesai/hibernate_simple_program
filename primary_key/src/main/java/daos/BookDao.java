package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pojos.Book;
import utils.HbUtil;

public class BookDao {
	public Book getBook(int id) {
		Session session = HbUtil.getSession();
		return session.get(Book.class, id);
	}
	public void addBook(Book b) {
		Session session = HbUtil.getSession();
		session.persist(b);
	}
	public void updateBook(Book b) {
		Session session = HbUtil.getSession();
		session.update(b);
	}
	public void deleteBook(int id) {
		Session session = HbUtil.getSession();
		Book b = getBook(id);
		if(b != null)
			session.remove(b);
	}
	public List<Book> getBooks() {
		Session session = HbUtil.getSession();
		String hql = "from Book b";
		Query q = session.createQuery(hql);
		return q.getResultList();
	}
}



