package hibernate.test.oneToMany.foreignKeyAsso;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class TestForeignKeyAssociation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        AccountEntity acc=new AccountEntity();
        acc.setAccountNumber("9551687030");
        
        EmployeeEntity emp=new EmployeeEntity();
        emp.setEmail("ramkumar@gamil.com");
        emp.setFirstName("ram");
        emp.setLastName("kumar");
        Set<AccountEntity> set=new HashSet<AccountEntity>();
        emp.setAccount(set);
        acc.setEmployee(emp);
        session.save(emp);
        session.save(acc);
        session.getTransaction().commit();
      //  HibernateUtil.shutdown();
        
	}

}
