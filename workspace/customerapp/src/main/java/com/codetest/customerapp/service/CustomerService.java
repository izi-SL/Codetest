package com.codetest.customerapp.service;

import java.util.List;

import com.codetest.customerapp.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
	

}
