package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;


public class BookDao {
	
	//basic CRUD methods: getBooks,addBoos, updateBook, deleteBook
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
	
	
 //1. RDBMS specific simple query (Not recommended)
	public List<String> getAuthors() {
		Session session = HbUtil.getSession();
		String sql = "SELECT DISTINCT AUTHOR FROM BOOKS";
		NativeQuery q = session.createSQLQuery(sql);
		return q.getResultList();
	}
	
//2. HQL query - select all books
	public List<Book> getBooks() {
		Session session = HbUtil.getSession();
		String hql = "from Book b";  //Book is name of entity class
		Query q = session.createQuery(hql);
		return q.getResultList();
	}

//3. HQL query - select by subject using namedQuery
	public List<Book> getSubjectBooks(String subject) {
		Session session = HbUtil.getSession();
		Query q = session.getNamedQuery("hqlGetSubjectBooks");
		q.setParameter(1, subject);
		return q.getResultList();
	}
	
//4. HQL query - select by subject and author name 
	public List<Book> getSubjectAuthorBooks(String subject, String author) {
		Session session = HbUtil.getSession();
		String hql = "from Book b where b.subject=:p_subject and b.author=:p_author";
		Query<Book> q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		q.setParameter("p_author", author);
		return q.getResultList();
	}
	
//5 select distinct subject using namedQuery
	public List<String> getDistinctSubjects() {
		Session session = HbUtil.getSession();
		Query q = session.getNamedQuery("hqlSubjects");
		return q.getResultList();
	}
	
//6 using constructor - get id, name and price of Book
	public List<Book> getBooksInfo3() {
		Session session = HbUtil.getSession();
		String hql = "select new Book(b.id, b.name, b.price) from Book b";
		Query<Book> q = session.createQuery(hql);
		return q.getResultList();
	}
	
//7 analytical query
	public Map<String, Double> getSubjectwiseBooksAvgPrice() {
		Session session = HbUtil.getSession();
		String hql = "select b.subject, avg(b.price) from Book b group by b.subject";
		Query<Object[]> q = session.createQuery(hql);
		Map<String, Double> result = new HashMap<String, Double>();
		for (Object[] tuple : q.getResultList())
			result.put((String)tuple[0], (Double)tuple[1]);
		return result;
	}
	
//8 update 
	public int increaseBookPriceOfSubject(String subject) {
		Session session = HbUtil.getSession();
		String hql = "update Book b set b.price = b.price + b.price * 0.05 where b.subject=:p_subject";
		Query q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.executeUpdate();
	}
	
//9 delete
	public int deleteBooksOfSubject(String subject) {
		Session session = HbUtil.getSession();
		String hql = "delete from Book b where b.subject=:p_subject";
		Query q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.executeUpdate();
	}
	
	
}
