package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pojos.Book;
import utils.JpaUtil;

public class BookDao implements AutoCloseable {
	private EntityManager em;
	public void open() {
		em = JpaUtil.getEntityManager();
	}
	public void close() {
		if(em != null)
			em.close();
	}
	
	//1. get Book using ID
	public Book getBook(int id) {
 		return em.find(Book.class, id);
	}
	
	//2. get book by subject using @NamedQuery in Book.java
	public List<Book> getBookBySubject(String subject) {
		Query q = em.createNamedQuery("hql_books_by_subject");
		q.setParameter("p_subject", subject);
		return q.getResultList();
	}
	
	//3. add book
	public void addBook(Book b) {
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	//4. update book
	public void updateBook(Book b) {
		try {
			em.getTransaction().begin();
			//em.merge(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	//5. delete book
	public void deleteBook(int id) {
		try {
			em.getTransaction().begin();
			Book b = getBook(id);
			if(b != null)
				em.remove(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}	
	}
	
	//6. Get book price by book-ID using Stored procedure
	public double getBookPrice(int id) {
		StoredProcedureQuery sp = em.createStoredProcedureQuery("SP_GET_PRICE");
		sp.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter(1, Double.class, ParameterMode.OUT);
		sp.setParameter(0, id);
		sp.execute();
		return (Double)sp.getOutputParameterValue(1);
	}
	
	//7. get book by author using CriteriaQuery
	public List<Book> getBooksByAuthor(String author) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Book> crQuery = builder.createQuery(Book.class);
		Root<Book> table = crQuery.from(Book.class);
		crQuery
			.select(table)
			.where(builder.equal(table.get("author"), author));
		TypedQuery<Book> query = em.createQuery(crQuery);
		return query.getResultList();
	}
}




