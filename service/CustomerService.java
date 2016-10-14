package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.dao.CustomerDAO;

public class CustomerService {
	public int createCustomer(Customer customer, String operatorName){
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.createCustomer(customer, operatorName);
	}
	
	public Customer searchCustomer(String emailID){
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.searchCustomer(emailID);
	}
	
	public int updateCustomer(Customer customer){
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.updateCustomer(customer);
	}
	
	public int deleteCustomer(String emailID){
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.deleteCustomer(emailID);
	}
}
