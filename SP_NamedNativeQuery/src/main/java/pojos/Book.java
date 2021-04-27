package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@NamedNativeQueries({
		@NamedNativeQuery(name = "sp_getbooks", 
				query = "CALL SP_GET_BOOKS(:p_author)", 
				hints = @QueryHint(name = "org.hibernate.callable", value = "true"),
				resultClass = Book.class) })
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String author;
	private String subject;
	private double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Book(int id, String name, String author, String subject, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ "]";
	}
}
