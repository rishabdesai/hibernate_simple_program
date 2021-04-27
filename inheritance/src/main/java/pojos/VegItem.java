package pojos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Veg")
public class VegItem extends Item {
	//empty
}
