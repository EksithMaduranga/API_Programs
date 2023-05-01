package com.account.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.database.service.AccountDao;

public class AccountPublishImpl implements AccountPublish{

	AccountDao accountDao = null;
	HashMap<String, String> customerModel = new HashMap<>();

	public AccountPublishImpl(AccountDao accountDao) {
		
		this.accountDao = accountDao;
		
	}

	@Override
	public void add() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter customer ID			: ");
		customerModel.put("customerId", scanner.nextLine());
		
		System.out.print("Enter customer name			: ");
		customerModel.put("customerName", scanner.nextLine());
		
		System.out.print("Enter customer's age		 	: ");
		customerModel.put("customerAge", Integer.toString(scanner.nextInt()));
		
		System.out.print("Enter customer's address		: ");
		customerModel.put("customerAddress", scanner.nextLine());
		
		System.out.print(" ");
		
		if (accountDao.save(customerModel)) {
			
			System.out.println("Customer created successfully ! ");
			
		} else {
			
			System.out.println("Something went wrong ! ");		
			
		}
		
	}

	@Override
	public void get() {
		
		System.out.print("Enter customer ID: ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = accountDao.findById(id);

		if (Objects.nonNull(data)) {
			
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
			
		} else {
			
			System.out.println("Sorry, We couldn't find any Customer with ID:" + id + " !");
			System.out.println("");
			
		}
		
	}

}
