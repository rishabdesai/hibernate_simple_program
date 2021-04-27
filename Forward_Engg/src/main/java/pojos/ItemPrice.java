package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_PRICING")
public class ItemPrice implements Serializable {
	@Id
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;
	@Column(name="sizes")
	private String size;
	@Column
	private double price;

	public ItemPrice() {
		this(0, new Item(), "", 0.0);
	}

	public ItemPrice(int id, Item item, String size, double price) {
		this.id = id;
		this.item = item;
		this.size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("ItemPrice [id=%s, item=%s, size=%s, price=%s]", id, item, size, price);
	}	
	
}
