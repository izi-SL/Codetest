package com.codetest.customerapp.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.codetest.customerapp.model.Customer;

@Repository
public class CustomerDAOImpl implements customerDAO{
	
	static Logger logger = Logger.getLogger(CustomerDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	
	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		logger.info("Customer Id = "+customer.getId()+" is added");
		customer=null;
			
	}

	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("cust DAO"+ customer.getId());
		session.update(customer);
		logger.info("Customer Id = "+customer.getId()+" is edited");
		customer=null;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, new Integer(id));
		return customer;
	}

	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if(customer != null){
			session.delete(customer);
		}
		logger.info("Customer Id = "+customer.getId()+" is deleted");
		customer=null;
	}

}
