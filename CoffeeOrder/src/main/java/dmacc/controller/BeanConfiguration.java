/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 10 - Assessment
// ** Bean Configuration for CoffeeOrder Class
// ** By Robert Fox, November 1, 2020
// *******************************************************
// **
// ** BennConfiguration controller for CoffeeOrder class.
*/


package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.CoffeeOrder;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public CoffeeOrder coffeeOrder() {
		
		CoffeeOrder bean = new CoffeeOrder();
		return bean;
	}
	

}
