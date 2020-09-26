package com.vinayak.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinayak.springdemo.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
	    Session session=sessionFactory.getCurrentSession();
	    
	    //create a query and sort by firstName
	    Query<Customer> query=session.createQuery("from Customer order by firstName",Customer.class);
	    
	    //execute query and get result set
	    List<Customer> customers=query.getResultList();
	    
	    //return customers
	    return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current session
		Session session=sessionFactory.getCurrentSession();
		
		//save the customer to DB
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get current session
		Session session=sessionFactory.getCurrentSession();
		
		//save the Customer to DB
		Customer customer=session.get(Customer.class,theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get current session
		Session session=sessionFactory.getCurrentSession();
		
		Query query=
				session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId",theId);
		query.executeUpdate();
	}
}
