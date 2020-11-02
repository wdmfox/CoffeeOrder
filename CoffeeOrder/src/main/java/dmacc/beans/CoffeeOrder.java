/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 10 - Assessment
// ** CoffeeOrder class declaration
// ** By Robert Fox, November 1, 2020
// *******************************************************
// **
// ** CoffeeOrder class declaration.
*/

package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String drinkSize;
	private String blend;
	private String extras;
	
	// default constructor
	public CoffeeOrder () {
		super();
	}
	
	// non-default constructor
	public CoffeeOrder (long id, String drinkSize, String blend, String extras) {
		super();
		this.id = id;
		this.drinkSize = drinkSize;
		this.blend = blend;
		this.extras = extras;
	}

	
	// getters and setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDrinkSize() {
		return drinkSize;
	}

	public void setDrinkSize(String drinkSize) {
		this.drinkSize = drinkSize;
	}

	public String getBlend() {
		return blend;
	}

	public void setBlend(String blend) {
		this.blend = blend;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	// toString method returns the coffee order properties in a concatenated string
	@Override
	public String toString() {
		return "CoffeeOrder [id=" + id + ", drinkSize=" + drinkSize + ", blend=" + blend + ", extras=" + extras + "]";
	}
	
	
	
}
