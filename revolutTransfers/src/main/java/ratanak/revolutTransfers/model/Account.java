package ratanak.revolutTransfers.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Account.NQ_LIST_ALL_ACCOUNTS, query = "SELECT a from Account a") })
public class Account {

	public static final String NQ_LIST_ALL_ACCOUNTS = "Account.ListAllAccounts";

	public Account() {
		// empty
	}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.active = true;
		this.created = new Date();
		this.lastUpdated = this.created;
		this.balance = new BigDecimal(0);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String accountNumber;

	@Column
	private BigDecimal balance;

	@Column
	private boolean active;

	@Column
	private Date created;

	@Column
	private Date lastUpdated;

	/*
	 * getters and setters
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
