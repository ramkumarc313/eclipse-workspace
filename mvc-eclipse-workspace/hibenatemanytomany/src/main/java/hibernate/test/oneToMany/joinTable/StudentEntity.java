package hibernate.test.oneToMany.joinTable;

import java.util.Set;

import javax.persistence.*;


@Entity(name = "JoinTableEmployeeEntity")
@Table(name = "Student", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID"),
@UniqueConstraint(columnNames = "EMAIL") })
public class StudentEntity {
	
	private static final long serialVersionUID = -1798070786993154676L;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer employeeId;
 
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;
 
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;
 
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;
    
    @OneToMany
    @JoinTable(name="Student_Account",joinColumns={@JoinColumn(name="employee_id",referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="account_id", referencedColumnName="id")})    
    private Set<LibraryEntity> library;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<LibraryEntity> getLibrary() {
		return library;
	}

	public void setLibrary(Set<LibraryEntity> library) {
		this.library = library;
	}
 

}
