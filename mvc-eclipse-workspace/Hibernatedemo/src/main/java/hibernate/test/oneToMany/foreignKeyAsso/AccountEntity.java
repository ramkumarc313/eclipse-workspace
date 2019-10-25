package hibernate.test.oneToMany.foreignKeyAsso;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="ForeignKeyAssoAccountEntity")
@Table(name="Acount",uniqueConstraints={@UniqueConstraint(columnNames="account_id")})
public class AccountEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id",unique=true,nullable=false)
	private int accountId;
	
	@Column(name="account_number",unique=true,nullable=false,length=30)
	private String AccountNumber;
	
	@ManyToOne
	private EmployeeEntity employee;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	
	
	
}
