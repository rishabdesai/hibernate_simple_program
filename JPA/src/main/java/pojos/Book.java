package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


//JPA-QL
@NamedQuery(name = "hql_books_by_subject", query = "from Book b where b.subject=:p_subject")
@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	private int id;
	private String name;
	private String author;
	private String subject;
	private double price;
	private double totalPrice;
	
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
	@Id
	@Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Column
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price < 0.0)
			throw new RuntimeException("Invalid price");
		this.price = price;
		this.totalPrice = price + price * 0.05;
	}
	@Transient
	public double getTotalPrice() {
		return totalPrice;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ "]";
	}
}

