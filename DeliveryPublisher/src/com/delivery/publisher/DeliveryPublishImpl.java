package com.delivery.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.database.service.DeliveryDao;

public class DeliveryPublishImpl implements DeliveryPublish{
	
	DeliveryDao deliveryDao = null;
	HashMap<String, String> deliveryModel = new HashMap<>();

	public DeliveryPublishImpl(DeliveryDao deliveryDao) {
		
		this.deliveryDao = deliveryDao;
		
	}

	@Override
	public void add() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter delivery ID				: ");
		deliveryModel.put("deliveryId", scanner.nextLine());
		
		System.out.print("Enter delivery name			: ");
		deliveryModel.put("deliveryName", scanner.nextLine());
		
		System.out.print("Enter delivery phone number	: ");
		deliveryModel.put("deliveryPhone", scanner.nextLine());
		
		System.out.print("Enter delivery address			: ");
		deliveryModel.put("deliveryAddress", scanner.nextLine());
		
		System.out.print(" ");
		
		if (deliveryDao.save(deliveryModel)) {
			
			System.out.println("Delivery assigned successfully ! ");
			
		} else {
			
			System.out.println("Something went wrong ! ");		
			
		}
		
	}

	@Override
	public void get() {
		
		System.out.print("Enter delivery ID: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = deliveryDao.findById(id);

		if (Objects.nonNull(data)) {
			
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
			
		} else {
			
			System.out.println("Sorry, We couldn't find any Delivery with ID:" + id + " !");
			System.out.println("");
			
		}
		
	}

}
