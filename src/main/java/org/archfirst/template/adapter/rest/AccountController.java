package org.archfirst.template.adapter.rest;

import java.util.List;

import org.archfirst.template.application.AccountService;
import org.archfirst.template.application.EntityNotFoundException;
import org.archfirst.template.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/accounts", method=RequestMethod.POST)
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}
	
	// The path variable id is not used
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		try {
			return new ResponseEntity<Account>(accountService.updateAccount(account), HttpStatus.OK);
		}
		catch (EntityNotFoundException e) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable int id) {
		try {
			return new ResponseEntity<Account>(accountService.getAccount(id), HttpStatus.OK);
		}
		catch (EntityNotFoundException e) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/accounts")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	@RequestMapping(value="/accounts/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
		try {
			accountService.deleteAccount(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		catch (EntityNotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
