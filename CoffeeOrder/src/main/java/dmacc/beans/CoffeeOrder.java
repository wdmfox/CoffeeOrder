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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String drinkSize;
	private String blend;
	private String extras;
	
}
