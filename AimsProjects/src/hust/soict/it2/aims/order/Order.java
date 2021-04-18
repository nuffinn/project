package hust.soict.it2.aims.order;

import java.util.ArrayList;
import java.util.Random;

import hust.soict.it2.aims.media.DigitalVideoDisc;
import hust.soict.it2.aims.media.Media;
import hust.soict.it2.aims.utils.MyDate;

public class Order {
	public Order() {
		super();
		nbOrders++;
		if(nbOrders == MAX_LIMITTED_ORDERS) System.out.println("Max number of orders reached");
	}

	public static final int MAX_NUMBER_ORDERED = 10;
	
	private MyDate dateOrdered = new MyDate();
	
	public static final int MAX_LIMITTED_ORDERS = 5;
	
	private static int nbOrders = 0;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void printItems(){
		System.out.println("***********************Order***********************");
		System.out.println("Date: "); dateOrdered.printDate();
		System.out.println("\nOrdered items: ");
		int u;
		for (u=0; u < itemsOrdered.size(); u++) {
			int z = u + 1;
			System.out.println(z + ". DVD"  + itemsOrdered.get(u).getTitle() + "-" + itemsOrdered.get(u).getCategory()+ "-" + ": " + itemsOrdered.get(u).getCost() + "$");
		}
		float c = totalCost();
		System.out.println("Total cost: " + c);
		System.out.println("***************************************************");
	}
	
	public float totalCost() {
		int y;
		float total = 0 ;
		total =0;
		for (y = 0; y < itemsOrdered.size(); y++) {
			total += itemsOrdered.get(y).getCost();
		}
		return total;
	}
	
	public void addMedia(Media media1) {
		itemsOrdered.add(media1);
	}
	
	public void removeMedia(Media media1) {
		itemsOrdered.remove(media1);
	}
	
	public Media getALuckyItem() {
		Random rd = new Random();
		int nb1 = rd.nextInt(itemsOrdered.size());
		Media temp = itemsOrdered.get(nb1);
		itemsOrdered.remove(nb1);
		return temp;
	}
}

