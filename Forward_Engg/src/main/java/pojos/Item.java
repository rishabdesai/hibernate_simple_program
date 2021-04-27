package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ITEMS")
public class Item implements Serializable {
	@Id
	@Column()
	private int id;
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private String category;
	@Column
	private String description;
	@OneToMany(mappedBy = "item")
	private List<ItemPrice> itemPrices;

	public Item() {
		this(0, "", "", "", "");
	}

	public Item(int id, String name, String type, String category, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.itemPrices = new ArrayList<ItemPrice>();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemPrice> getItemPrices() {
		return itemPrices;
	}

	public void setItemPrices(List<ItemPrice> itemPrices) {
		this.itemPrices = itemPrices;
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, type=%s, category=%s, description=%s]", id, name, type, category,
				description);
	}
	

}

