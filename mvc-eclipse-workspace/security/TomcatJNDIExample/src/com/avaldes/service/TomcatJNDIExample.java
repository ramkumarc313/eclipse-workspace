package com.avaldes.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.avaldes.dao.CustomerDAO;
import com.avaldes.dao.impl.CustomerDAOImpl;
import com.avaldes.model.Customer;

@Path("tomcat")
public class TomcatJNDIExample {
	private Logger logger = Logger.getLogger(TomcatJNDIExample.class);	
	
	@Path("status")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getStatus() {
		logger.info("Inside getStatus()...");
		return "TomcatJNDIExample Status is OK...";
	}

	@GET
	@Path("getcustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@DefaultValue("1") @QueryParam("id") int id) {

		CustomerDAO daoImpl = new CustomerDAOImpl();
		logger.info("Inside getCustomer...");
		
		Response resp = daoImpl.getCustomer(id);
		return resp;
	}

	@POST
	@Path("addcustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer) {

		CustomerDAO daoImpl = new CustomerDAOImpl();
		logger.info("Inside createCustomer...");
		
		Response resp = daoImpl.createCustomer(customer);
		return resp;
	}
	
	@PUT
	@Path("updatecustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCustomer(Customer customer) {

		CustomerDAO daoImpl = new CustomerDAOImpl();
		logger.info("Inside createCustomer...");
		
		Response resp = daoImpl.updateCustomer(customer);
		return resp;
	}
	
	@DELETE
	@Path("deletecustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@DefaultValue("0") @QueryParam("id") int id) {

		CustomerDAO daoImpl = new CustomerDAOImpl();
		logger.info("Inside deleteCustomer...");
		
		Response resp = daoImpl.deleteCustomer(id);
		return resp;
	}
	
	@GET
	@Path("showallcustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAllCustomers() throws JsonGenerationException,
		JsonMappingException, IOException {

		CustomerDAO daoImpl = new CustomerDAOImpl();
		logger.info("Inside showAllCustomers...");
		Response resp = daoImpl.getAllCustomers();
		
		return resp;
	}
	
}
