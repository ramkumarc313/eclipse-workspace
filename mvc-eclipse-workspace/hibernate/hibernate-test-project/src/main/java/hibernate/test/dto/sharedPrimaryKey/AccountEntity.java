package hibernate.test.dto.sharedPrimaryKey;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "SharedPrimaryKeyAccountEntity")
@Table(name = "ACCOUNT_PRIMARY", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class AccountEntity implements Serializable 
{

	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
	private Integer accountId;

	@Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
	private String accountNumber;
	
	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
	private EmployeeEntity employee; 

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
