package com.artist.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.database.service.ArtistDao;

public class ArtistPublishImpl implements ArtistPublish{

	ArtistDao artistDao = null;
	HashMap<String, String> artistModel = new HashMap<>();

	public ArtistPublishImpl(ArtistDao artistDao) {
		
		this.artistDao = artistDao;
		
	}

	@Override
	public void add() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter artist ID			: ");
		artistModel.put("artistId", scanner.nextLine());
		
		System.out.print("Enter artist name			: ");
		artistModel.put("artistName", scanner.nextLine());
		
		System.out.print("Enter artist's age		 	: ");
		artistModel.put("artistAge", Integer.toString(scanner.nextInt()));
		
		System.out.print("Enter artist's address		: ");
		artistModel.put("artistAddress", scanner.nextLine());
		
		System.out.print(" ");
		
		if (artistDao.save(artistModel)) {
			
			System.out.println("Artist created successfully ! ");
			
		} else {
			
			System.out.println("Something went wrong ! ");		
			
		}
		
	}

	@Override
	public void get() {
		
		System.out.print("Enter artist ID: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = artistDao.findById(id);

		if (Objects.nonNull(data)) {
			
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
			
		} else {
			
			System.out.println("Sorry, We couldn't find any Artist with ID:" + id + " !");
			System.out.println("");
			
		}
		
	}

}
