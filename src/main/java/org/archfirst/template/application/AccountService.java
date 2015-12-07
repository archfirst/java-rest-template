package org.archfirst.template.application;

import java.util.List;

import org.archfirst.template.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account createAccount(Account account) {
		accountRepository.createAccount(account);
		return account;
	}

	public Account updateAccount(Account account) throws EntityNotFoundException {
		accountRepository.updateAccount(account);
		return account;
	}

	public Account getAccount(int id) throws EntityNotFoundException {
		return accountRepository.getAccount(id);
	}

	public List<Account> getAccounts() {
		return accountRepository.getAccounts();
	}

	public void deleteAccount(int id) throws EntityNotFoundException {
		accountRepository.deleteAccount(id);
	}
}
