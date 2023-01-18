package com.hh.springdemoaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hh.springdemoaop.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;

//	add a new method: findAccounts()

	public List<Account> findAccounts(boolean tripWire) {

//		for academic purpose ... sumulate an exception
		if (tripWire) {
			throw new RuntimeException("No soup for you!!");
		}

		List<Account> accounts = new ArrayList<>();
//		create some sample accounts

		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");

//		add them to our account list
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);

		return accounts;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCONT");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
