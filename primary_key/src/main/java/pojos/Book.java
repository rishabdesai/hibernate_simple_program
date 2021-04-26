package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	@Id
	@GeneratedValue(generator="gen", strategy=GenerationType.IDENTITY)
	
	//@GeneratedValue(generator="gen", strategy=GenerationType.AUTO)
	
	//@TableGenerator(name="gen", initialValue=1000, pkColumnName="name", valueColumnName="id", table="id_gen", allocationSize=1)
	//@GeneratedValue(generator="gen", strategy=GenerationType.TABLE)
	
	//@GenericGenerator(name = "gen", strategy = "increment")
	//@GeneratedValue(generator = "gen")
	
	private int id;
	private String name;
	private String author;
	private String subject;
	private double price;
	
	public Book() {
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






