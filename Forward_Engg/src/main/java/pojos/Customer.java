package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_CUSTOMERS")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(generator = "g", strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(length = 40)
	private String name;
	@Column(length = 80)
	private String address;
	@Column(length = 12)
	private String mobile;
	@Column(length = 30, unique = true, updatable = false)
	private String email;
	@Column(length = 30)
	private String password;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	public Customer() {
		this(0, "", "", "", "", "");
	}

	public Customer(int id, String name, String address, String mobile, String email, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.orders = new ArrayList<Order>();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, address=%s, mobile=%s, email=%s, password=%s]", id, name,
				address, mobile, email, password);
	}
}