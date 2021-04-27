package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDERS")
public class Order implements Serializable {
	@Id
	@GeneratedValue(generator = "g", strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name="customerId", updatable = false)
	private Customer customer;
	@Column
	private Date orderTime;
	@Column
	private String status;
	@OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
	private List<OrderDetail> orderDetails;
	
	public Order() {
		this(0, new Customer(), new Date(0), "");
	}

	public Order(int id, Customer customer, Date orderTime, String status) {
		this.id = id;
		this.customer = customer;
		this.orderTime = orderTime;
		this.status = status;
		this.orderDetails = new ArrayList<OrderDetail>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s, customer=%s, orderTime=%s, status=%s]", id, customer, orderTime, status);
	}

}

