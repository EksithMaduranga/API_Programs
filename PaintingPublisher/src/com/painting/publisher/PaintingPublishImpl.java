package com.painting.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.database.service.PaintingDao;

public class PaintingPublishImpl implements PaintingPublish{
	
	PaintingDao paintingDao = null;
	HashMap<String, String> paintingModel = new HashMap<>();

	public PaintingPublishImpl(PaintingDao paintingDao) {
		
		this.paintingDao = paintingDao;
	 
	}
		
	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter painting id         : ");
		paintingModel.put("paintingId", scanner.nextLine());
		System.out.print("Enter painting name       : ");
		paintingModel.put("paintingName", scanner.nextLine());
		System.out.print("Enter painting category   : ");
		paintingModel.put("paintingCategory", scanner.nextLine());
		System.out.print("Enter painting price : ");
		paintingModel.put("paintingPrice", Double.toString(scanner.nextDouble()));
		System.out.println("");
		if (paintingDao.save(paintingModel)) {
			System.out.println("Painting added successfully !!! ");
		} else {
			System.out.println("Sorry something went wrong !!! ");			
		}
		
	}
	
	@Override
	public void get() {
		System.out.print("Enter painting id: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = paintingDao.findById(id);

		if (Objects.nonNull(data)) {
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
		} else {
			System.out.println("Painting id:" + id + " not found !!!");
			System.out.println("");
		}
		
	}
	
}
