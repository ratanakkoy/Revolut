package ratanak.revolutTransfers.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ratanak.revolutTransfers.SessionUtil;
import ratanak.revolutTransfers.model.Account;

public class AccountDAO {

	/**
	 * get all accounts
	 * 
	 * @return list of accounts
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() {
		EntityManager em = SessionUtil.getEntityManager();
		em.getTransaction().begin();
		List<Account> accounts = em.createNamedQuery(Account.NQ_LIST_ALL_ACCOUNTS).getResultList();
		em.getTransaction().commit();
		em.close();
		return accounts;
	}

	/**
	 * get an account by id
	 * 
	 * @param id
	 * @return account
	 */
	public Account getAccount(int accountId) {
		EntityManager em = SessionUtil.getEntityManager();
		em.getTransaction().begin();
		Account account = em.find(Account.class, accountId);
		em.getTransaction().commit();
		em.close();
		return account;
	}

	/**
	 * create a new account with accountNumber
	 * 
	 * @param accountNumber
	 */
	public void createAccount(String accountNumber) {
		EntityManager em = SessionUtil.getEntityManager();
		em.getTransaction().begin();
		Account account = new Account(accountNumber);
		em.persist(account);
		em.getTransaction().commit();
	}
}
