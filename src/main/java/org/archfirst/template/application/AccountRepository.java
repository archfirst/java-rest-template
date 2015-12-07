package org.archfirst.template.application;

import java.util.List;

import org.archfirst.template.domain.Account;

public interface AccountRepository {
	public void createAccount(Account account);
	public void updateAccount(Account account) throws EntityNotFoundException;
	public Account getAccount(int id) throws EntityNotFoundException;
	public List<Account> getAccounts();
	public void deleteAccount(int id) throws EntityNotFoundException;
	public void dropData();
}
