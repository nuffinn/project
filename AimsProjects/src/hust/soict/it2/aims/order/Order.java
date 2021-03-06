package hust.soict.it2.aims.order;

import java.util.ArrayList;
import java.util.Random;

import javax.naming.LimitExceededException;

import hust.soict.it2.aims.media.Book;
import hust.soict.it2.aims.media.CompactDisc;
import hust.soict.it2.aims.media.DigitalVideoDisc;
import hust.soict.it2.aims.media.Media;
import hust.soict.it2.aims.utils.MyDate;

public class Order {
	public Order() throws LimitExceededException {
		if (Order.nbOrders < MAX_LIMITTED_ORDERS) {
			nbOrders ++;
		} else {
			throw new LimitExceededException("The number of orders has reached its limit!");
		}
	}
	
	public Order(int id1) {
		super();
		this.id = id1;
		nbOrders++;
		if(nbOrders == MAX_LIMITTED_ORDERS) System.out.println("Max number of orders reached");
	}

	public static final int MAX_NUMBER_ORDERED = 10;
	
	private MyDate dateOrdered = new MyDate();
	
	public static final int MAX_LIMITTED_ORDERS = 5;
	
	private static int nbOrders = 0;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	private int id;
	
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
		if (itemsOrdered.contains(media1)) {
			return;
		}else itemsOrdered.add(media1);
	}
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsOrdered.add(dvd);
	}
	
	public void addCD(CompactDisc cd) {
		itemsOrdered.add(cd);
	}
	
	public void addBook(Book book) {
		itemsOrdered.add(book);
	}
	
	public void removeMedia(Media media1) {
		itemsOrdered.remove(media1);
	}
	
	public void removeById(int ind) {
		for (int c =0; c < itemsOrdered.size(); c++) {
			if (itemsOrdered.get(c).getId()== ind) {
				itemsOrdered.remove(c);
				break;
			} else System.out.println("No item with id " + ind);
		}
	}
	
	public Media getALuckyItem() {
		Random rd = new Random();
		int nb1 = rd.nextInt(itemsOrdered.size());
		Media temp = itemsOrdered.get(nb1);
		itemsOrdered.remove(nb1);
		return temp;
	}
	
	public Media getItemById(int index) {
		for(int i =0; i< nbOrders; i++) {
			if (itemsOrdered.get(i).getId() == index) return itemsOrdered.get(i);
		}
		return itemsOrdered.get(0);
	}
	
}

