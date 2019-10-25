package hibernate.test.oneToMany.joinTable;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		LibraryEntity lib=new LibraryEntity();
		lib.setAccountNumber("786876");
		
		StudentEntity student=new StudentEntity();
		student.setEmail("ramkumarc313@gmail.com");
		student.setFirstName("ram");
		student.setLastName("kumar");
		
		Set<LibraryEntity> set=new HashSet<LibraryEntity>();
		set.add(lib);
		student.setLibrary(set);
		session.save(student);
		session.save(lib);
		 session.getTransaction().commit();
	     HibernateUtil.shutdown();

	}

}
