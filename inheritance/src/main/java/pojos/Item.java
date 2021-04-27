package pojos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ITEMS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Item {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String category;
	@Column
	private String description;
	
	public Item() {
		
	}

	public Item(int id, String name, String category, String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
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

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, category=%s, description=%s]", id, name, category, description);
	}
}
