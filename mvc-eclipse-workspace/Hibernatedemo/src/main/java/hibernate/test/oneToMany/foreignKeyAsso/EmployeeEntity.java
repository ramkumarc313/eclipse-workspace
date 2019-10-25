package hibernate.test.oneToMany.foreignKeyAsso;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity(name="ForeignKeyAssoEntity")
@Table(name="Employee",uniqueConstraints = {@UniqueConstraint(columnNames="id"),@UniqueConstraint(columnNames="Email")})
public class EmployeeEntity implements Serializable {
	
    private static final long serialVersionUID = -1798070786993154676L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private int id;
    
    @Column(name="email",unique=true,nullable=false,length=100)
    private String Email;
    
    @Column(name="first_name",unique=true,nullable=false,length=30)
    private String firstName;
    
    @Column(name="last_name",unique=true,nullable=false,length=30)
    private String lastName;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="EMPLOYEE_ID")
    private Set<AccountEntity> account;
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<AccountEntity> getAccount() {
		return account;
	}

	public void setAccount(Set<AccountEntity> account) {
		this.account = account;
	}

	
    
    
    
    


}
