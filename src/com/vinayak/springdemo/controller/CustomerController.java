package com.vinayak.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinayak.springdemo.dao.CustomerDAO;
import com.vinayak.springdemo.entity.Customer;
import com.vinayak.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomer(Model theModel)
	{
		//get customers from the service
		List<Customer> customers=customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers",customers);
		
		//add customers to the model
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create model attribute to bind form data
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//saving customer using customer service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			                        Model theModel)
	{
		//get customer from the DB
	    Customer theCustomer=customerService.getCustomer(theId);
	    
		//set customer as a model to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form
		return	"customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
