package com.codetest.customerapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetest.customerapp.enums.Department;
import com.codetest.customerapp.model.Customer;
import com.codetest.customerapp.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/add" , method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		
		//Validation
		if(bindingResult.hasErrors()){
			return "customerView";
		}
		
		if(customer.getId() == 0){
			//new customer therefore save
			this.customerService.addCustomer(customer);
		}else{
			// existing user therefore update
			this.customerService.updateCustomer(customer);
		}
		return "redirect:/customer.html";
	}
	
	@RequestMapping(value = "/customer" , method = RequestMethod.GET)
	public String listCustomers(Model model){
		model.addAttribute("customer" , new Customer());
		model.addAttribute("listCustomer" , this.customerService.listCustomers());
		model.addAttribute("enumDepartment", Department.values());
		return "customerView";
	}
	
	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable("id") int id, Model model){
		model.addAttribute("customer", this.customerService.getCustomerById(id));
		model.addAttribute("listCustomer", this.customerService.listCustomers());
		model.addAttribute("enumDepartment", Department.values());
		return "customerView";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeCustomer(@PathVariable("id") int id, Model model){
		this.customerService.removeCustomer(id);
		return "redirect:/customer.html";
	}
}
