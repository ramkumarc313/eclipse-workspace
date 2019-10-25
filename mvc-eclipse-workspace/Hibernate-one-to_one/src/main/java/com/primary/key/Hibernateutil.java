package com.primary.key;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	private static final SessionFactory sessionFactory=buildSessionFactory();
	
    private static SessionFactory buildSessionFactory() {
    	
    	try
    	{
    		Configuration config=new AnnotationConfiguration().configure(new File("D:\\Developer\\mvc-eclipse-workspace\\Hibernate-one-to_one\\hibernate.cfg.xml"));
    		return config.buildSessionFactory();
    	}
    	catch(Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
    	}
	
    	
    }
    
    
    public static SessionFactory getSessionFactory() {
    	
    	return sessionFactory;
    }
    
    
    public static void shutdown()
    {
    	getSessionFactory().close();
    }


}
