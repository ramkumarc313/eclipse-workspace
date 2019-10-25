package com.avaldes.dao;

import javax.ws.rs.core.Response;

import com.avaldes.model.Customer;

public interface CustomerDAO {
	
	public Response getCustomer(int id);
	public Response createCustomer(Customer customer);
	public Response updateCustomer(Customer customer);
	public Response deleteCustomer(int id);
	public Response getAllCustomers();
	
}
