package org.archfirst.template.adapter.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.archfirst.template.application.AccountRepository;
import org.archfirst.template.application.EntityNotFoundException;
import org.archfirst.template.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	int nextAccountId = 1;

	@Override
	public void createAccount(Account account) {
		account.setId(nextAccountId++);
		accountMap.put(account.getId(), account);
	}

	@Override
	public void updateAccount(Account updatedAccount) throws EntityNotFoundException {
		Account account = accountMap.get(updatedAccount.getId());
		if (account == null) {
			throw new EntityNotFoundException("Account " + updatedAccount.getId() + " does not exist");
		}
		
		account.copyFrom(updatedAccount);
	}

	@Override
	public Account getAccount(int id) throws EntityNotFoundException {
		Account account = accountMap.get(id);
		if (account == null) {
			throw new EntityNotFoundException("Account " + id + " does not exist");
		}
		
		return account;
	}

	@Override
	public List<Account> getAccounts() {
		return new ArrayList<Account>(accountMap.values());
	}

	@Override
	public void deleteAccount(int id) throws EntityNotFoundException {
		Account account = accountMap.get(id);
		if (account == null) {
			throw new EntityNotFoundException("Account " + id + " does not exist");
		}
		
		accountMap.remove(id);
		
	}

	@Override
	public void dropData() {
		accountMap.clear();
	}
}
