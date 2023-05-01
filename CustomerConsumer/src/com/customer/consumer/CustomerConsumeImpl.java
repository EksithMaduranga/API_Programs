package com.customer.consumer;


import java.util.Scanner;

import com.account.publisher.AccountPublish;
import com.artist.publisher.ArtistPublish;
import com.delivery.publisher.DeliveryPublish;
import com.painting.publisher.PaintingPublish;

public class CustomerConsumeImpl implements CustomerConsume{
	
	ArtistPublish artistPublish;
	DeliveryPublish deliveryPublish; 
	PaintingPublish paintingPublish;
	AccountPublish accountPublish;
	
	public CustomerConsumeImpl(ArtistPublish artistPublish , DeliveryPublish deliveryPublish, PaintingPublish paintingPublish, AccountPublish accountPublish) {
		
		this.artistPublish = artistPublish;
		this.deliveryPublish = deliveryPublish; 
		this.paintingPublish = paintingPublish;
		this.accountPublish = accountPublish;
		
	}

	@Override
	public void init() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("*** Online Art Gallery System ***");
		welcomePrompt();
		int input = in.nextInt();
		while (input != 5) {

			switch (input) {
			case 1:
				customer();
				break;
			case 2:
				artist();
				break;
			case 3:
				delivery();
				break;
			case 4:
				painting();
				break;
			default:
				System.out.println("Invalid input !");
				break;
			}
			welcomePrompt();
			input = in.nextInt();
		}

	}

	private void welcomePrompt() {
		System.out.println("");
		System.out.println("What do you need to do ?");
		System.out.println("  1 - Customer Management");
		System.out.println("  2 - Artist Management");
		System.out.println("  3 - Delivery Management");
		System.out.println("  4 - Painting Management");
		System.out.println("  5 - Exit");
		System.out.println("");
		System.out.print("Please enter a number : ");
	}
	
	@Override
	public void artist() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Artist Management");
		System.out.println("How would you like to proceed ?");
		System.out.println("  1 - Add new artist");
		System.out.println("  2 - Search artist");
		System.out.println("  3 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 3) {

			switch (input) {
			case 1:
				artistPublish.add();
				break;
			case 2:
				artistPublish.get();
				break;
			default:
				System.out.println("Invalid input !");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
	}

	@Override
	public void customer() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Customer Management");
		System.out.println("How would you like to proceed ?");
		System.out.println("  1 - Add new customer");
		System.out.println("  2 - Search customer");
		System.out.println("  3 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 3) {

			switch (input) {
			case 1:
				accountPublish.add();
				break;
			case 2:
				accountPublish.get();
				break;
			default:
				System.out.println("Invalid input !");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
	}
	
	@Override
	public void delivery() {
		
	Scanner in = new Scanner(System.in);
	System.out.println("");
	System.out.println("Delivery Management");
	System.out.println("How would you like to proceed ?");
	System.out.println("  1 - Add new delivery");
	System.out.println("  2 - View delivery details");
	System.out.println("  3 - Back");
	System.out.println("");

	System.out.print("Please enter a number : ");
	int input = in.nextInt();

	while (input != 3) {

		switch (input) {
		case 1:
			deliveryPublish.add();
			break;
		case 2:
			deliveryPublish.get();
		default:
			System.out.println("Invalid input !");
			break;
		}
		System.out.print("Please enter a number : ");
		input = in.nextInt();
	
		}
	}

	@Override
	public void painting() {
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Painting Management");
		System.out.println("How would you like to proceed?");
		System.out.println("  1 - Add new painting");
		System.out.println("  2 - View painting details");
		System.out.println("  3 - Back");
		System.out.println("");

		System.out.print("Please enter a number : ");
		int input = in.nextInt();

		while (input != 3) {

			switch (input) {
			case 1:
				paintingPublish.add();
				break;
			case 2:
				paintingPublish.get();
				break;
			default:
				System.out.println("Invalid input !");
				break;
			}
			System.out.print("Please enter a number : ");
			input = in.nextInt();
		}
		
	}

}
