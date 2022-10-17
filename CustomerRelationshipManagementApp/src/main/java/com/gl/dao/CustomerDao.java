package com.gl.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.gl.model.Customer;

@Component
public class CustomerDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	// add customer
	@Transactional
	public void addCustomer(Customer cus) {
		hibernateTemplate.save(cus);		
	}
	//get all Customers
	public List<Customer> getAllCus(){
		return hibernateTemplate.loadAll(Customer.class);
	}
	
	//get customer by id
	public Customer getCusById(int id) {
		return hibernateTemplate.get(Customer.class,id);
	}
		
	//update customer
	@Transactional
	public void updateCus(Customer cus) {
		hibernateTemplate.update(cus);
		
	}
	
	//delete customer
	@Transactional
	public void deleteCus(int id) {
		hibernateTemplate.delete(hibernateTemplate.load(Customer.class, id));
		
	}
	
	
		
	
}
