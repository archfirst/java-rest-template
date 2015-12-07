package org.archfirst.template.adapter.rest;

import org.archfirst.template.application.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	/**
	 * Deletes all data if the id matches.
	 * *** DON'T EXPOSE SUCH A SERVICE IN A PRODUCTION APP ***
	 *
	 * Path variable id must contains the magic id = 1234 for the request to succeed!
	 */
	@RequestMapping(value="/tests/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> dropData(@PathVariable int id) {
		
		if (id != 1234) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);			
		}
		
		testService.dropData();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
