package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDERDETAILS")
public class OrderDetail implements Serializable {
	@Id
	@GeneratedValue(generator = "g", strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	@ManyToOne
	@JoinColumn(name="priceId")
	private ItemPrice itemPrice;
	
	public OrderDetail() {
		this(0, new Order(), new ItemPrice());
	}
	
	public OrderDetail(int id, Order order, ItemPrice itemPrice) {
		this.id = id;
		this.order = order;
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemPrice getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return String.format("OrderDetail [id=%s, order=%s, itemPrice=%s]", id, order, itemPrice);
	}
}
