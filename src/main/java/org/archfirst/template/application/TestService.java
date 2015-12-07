package org.archfirst.template.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Drops all data from all repositories.
	 */
	public void dropData() {
	    accountRepository.dropData();
	}
}
