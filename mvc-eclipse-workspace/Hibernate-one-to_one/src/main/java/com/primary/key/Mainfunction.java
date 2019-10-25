package com.primary.key;

import org.hibernate.Session;

import com.primary.model.DsCarton;
import com.primary.model.DsInvoice;


public class Mainfunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=Hibernateutil.getSessionFactory().openSession();
		session.beginTransaction();
		
		DsInvoice ds=new DsInvoice();
		ds.setInvoiceNo("A7676");
		ds.setShipper("ram");
		ds.setConsignee("kumar");
		ds.setState("TN");
		
		DsCarton carton=new DsCarton();
		carton.setCartonNo(1);
		carton.setQty(10);
		carton.setWeight(30);
		carton.setItemName("apple");
		
		carton.setInvoice(ds);
		ds.setCarton(carton);
		
		
		
		session.save(ds);
		
		session.getTransaction().commit();
		Hibernateutil.shutdown();
	}

}
