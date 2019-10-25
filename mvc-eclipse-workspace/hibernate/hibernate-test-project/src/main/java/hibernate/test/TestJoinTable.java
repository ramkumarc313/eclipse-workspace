package hibernate.test;

import hibernate.test.dto.joinTable.AccountEntity;
import hibernate.test.dto.joinTable.EmployeeEntity;

import org.hibernate.Session;

public class TestJoinTable
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-65454");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("ram-user@mail.com");
		emp.setFirstName("ram");
		emp.setLastName("kumar");
		
		emp.setAccount(account);
		//Save Employee
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
