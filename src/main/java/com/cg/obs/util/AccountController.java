/**
 * 
 */
package com.cg.obs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.Account;
import com.cg.obs.service.AccountService;

/**
 * @author sohel
 *
 */
@RestController
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping(path = "/accounts")
	public List<Account> getAllAccounts() {
		System.out.println("this function will return list of all accunts");
		return service.findAll();
	}

	@GetMapping(path = "/accounts/{accountNo}")
	public Account getAccountByAccountNo(@PathVariable String accountNo) {
		System.out.println("This function will return account by accountNo");
		return service.findById(accountNo).get();
	}

	@GetMapping(path = "/accounts/pending")
	public List<Account> getPendingAccounts() {
		System.out.println("This function will return list of all pending account");
		return service.findAll().stream().filter(x->("Pending".equals(x.getAccountStatus()))).collect(Collectors.toList());
	}
	
	@GetMapping(path = "/accounts/foruser/{userId}")
	public List<Account> getAccountsForUser(@PathVariable String userId){
		System.out.println("this will return list of accounts for a user");
		return service.getAccountsByUserId(userId);
	}

	@PostMapping(path = "/accounts/add")
	public String addAccount(@RequestBody Account account) {
		System.out.println("this function will add account in database");
		service.save(account);
		return "account added";
	}

	@DeleteMapping(path = "/accounts/delete/{accountNo}")
	public String deleteAccount(@PathVariable String accountNo) {
		System.out.println("This function will delete account");
		service.deleteById(accountNo);
		return "account deleted";
	}

	@PutMapping(path = "/accounts/update")
	public String updateAccount(@RequestBody Account account) {
		System.out.println("This function will update account");
		service.deleteById(account.getAccountNo());
		service.save(account);
		return "Account Updated";
	}
}
