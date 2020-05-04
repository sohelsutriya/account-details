/**
 * 
 */
package com.cg.obs.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.Account;

/**
 * @author sohel
 *
 */
@RestController
public class AccountController {
	@GetMapping(path = "/accounts")
	public List<Account> getAllAccounts() {
		System.out.println("this function will return list of all accunts");
		return new ArrayList<Account>();
	}

	@GetMapping(path = "/accounts/{accountNo}")
	public Account getAccountByAccountNo(@PathVariable String accountNo) {
		System.out.println("This function will return account by accountNo");
		return new Account();
	}

	@GetMapping(path = "/accounts/pending")
	public List<Account> getPendingAccounts() {
		System.out.println("This function will return list of all pending account");
		return new ArrayList<Account>();
	}
	
	@GetMapping(path = "/accounts/foruser/{userId}")
	public List<Account> getAccountsForUser(@PathVariable String userId){
		System.out.println("this will return list of accounts for a user");
		return new ArrayList<Account>();
	}

	@PostMapping(path = "/accounts/add")
	public String addAccount(@RequestBody Account account) {
		System.out.println("this function will add account in database");
		return "account added";
	}

	@DeleteMapping(path = "/accounts/delete/{accountNo}")
	public String deleteAccount(@PathVariable int accountNo) {
		System.out.println("This function will delete account");
		return "account deleted";
	}

	@PutMapping(path = "/accounts/update")
	public String updateAccount(@RequestBody Account account) {
		System.out.println("This function will update account");
		return "Account Updated";
	}
}
