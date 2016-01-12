package com.codetest.customerapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.customerapp.DAO.customerDAO;
import com.codetest.customerapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	private customerDAO customerDAO;
	
	public void setCustomerDAO(customerDAO customerDAO){
		this.customerDAO = customerDAO;
	}
	
	@Transactional
	public void addCustomer(Customer customer) {
		this.customerDAO.addCustomer(customer);
		
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		this.customerDAO.updateCustomer(customer);
		
	}

	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		
		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

}
