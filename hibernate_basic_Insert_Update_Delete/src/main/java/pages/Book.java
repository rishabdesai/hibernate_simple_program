package pages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "BOOKS") //BOOKS is name of table
public class Book implements Serializable {
	@Id  				//primary key
	@Column(name="id")  // column name 
	private int id;
	@Column(name="name")
	private String title;
	@Column //(name="author")
	private String author;
	//@Column
	private String subject;
	@Column(name="price")
	private double cost;
	@Transient  
	private double finalPrice;
	
	public Book() {
	}
	
	public Book(int id, String title, String author, String subject, double cost) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getFinalPrice() {
		finalPrice = this.cost * 0.05;
		return finalPrice;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", subject=" + subject + ", cost=" + cost
				+ "]";
	}
}
