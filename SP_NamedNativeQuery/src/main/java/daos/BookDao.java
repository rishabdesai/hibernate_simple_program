package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import pojos.Book;
import utils.HbUtil;

public class BookDao {

	public List<Book> getBooksByAuthor(String author) {
		Session session = HbUtil.getSession();
		NativeQuery<Book> q = session.getNamedNativeQuery("sp_getbooks");
		q.setParameter("p_author", author);
		return q.getResultList();
	}

}
