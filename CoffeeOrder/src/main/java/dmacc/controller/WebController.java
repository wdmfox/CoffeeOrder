/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 10 - Assessment
// ** WebController for CoffeeOrder Application
// ** By Robert Fox, November 1, 2020
// *******************************************************
// **
// ** WebController for CoffeeOrderApplication
*/

package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.CoffeeOrder;
import dmacc.repository.CoffeeOrderRepository;

@Controller
public class WebController {
	@Autowired
	CoffeeOrderRepository repo;
	
	// viewAllOrders is executed when application starts or when
	// /viewAll button is clicked.  Returns all coffee orders
	// currently in the coffee order table or invokes the 
	// new coffee order page if table is empty
	@GetMapping({"/", "/viewAll"})
	public String viewAllOrders(Model model) {
		if (repo.findAll().isEmpty() ) {
			return addNewCoffeeOrder(model);
		}
		
		model.addAttribute("orders", repo.findAll());
		return "results";
	}
	
	// addNewCoffeeOrder GetMapping executes when the 
	// Add A New Coffee Order button is clicked
	// on the results.html page
	@GetMapping("/inputOrder")
	public String addNewCoffeeOrder(Model model) {
		CoffeeOrder c = new CoffeeOrder();
		model.addAttribute("newCoffeeOrder", c);
		return "input";
	}
	
	// showUpdateCoffeeOrder is executed when the 
	// Edit button is clicked next to an order
	// on the results.html page.  The id pointer
	// for the selected order is passed in and 
	// the coffee order instance is sent as
	// an attribute to be picked up the the
	// input.html page
	@GetMapping("/edit/{id}")
	public String showUpdateCoffeeOrder(@PathVariable("id") long id, Model model) {
		CoffeeOrder c = repo.findById(id).orElse(null);
		model.addAttribute("newCoffeeOrder", c);
		return "input";
	}
	
	// updateCoffeeOrder is executed when submit button
	// is clicked on the input.html page.  The id pointer
	// to the coffee order is passed in and saved to the
	// table.
	@PostMapping("/update/{id}")
	public String updateCoffeeOrder(CoffeeOrder c, Model model) {
		repo.save(c);
		return viewAllOrders(model);
	}
	
	// deleteCoffeeOrder is executed when the delete button
	// is clicked next to an order on the results.html page.
	// The id pointer to the order is passed here and a delete
	// request is made.
	@GetMapping("/delete/{id}")
	public String deleteCoffeeOrder(@PathVariable("id") long id, Model model) {
		CoffeeOrder c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllOrders(model);
	}
	
}
