package pojos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NonVeg")
public class NonVegItem extends Item {
	//empty
}
