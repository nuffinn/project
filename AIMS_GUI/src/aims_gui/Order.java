package aims_gui;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Order {
	public Order() {
		super();
//		nbOrders++;
//		if(nbOrders == MAX_LIMITTED_ORDERS) System.out.println("Max number of orders reached");
	}
	
	public Order(String name) {
		super();
		this.name = name;
		nbOrders++;
//		if(nbOrders == MAX_LIMITTED_ORDERS) System.out.println("Max number of orders reached");
	}
	
	public Order(String name, int id) {
		super();
		this.name = name;
		this.id= id;
	}
	
	private String name;

	public static final int MAX_NUMBER_ORDERED = 10;
	
	private MyDate dateOrdered = new MyDate();
	
//	public static final int MAX_LIMITTED_ORDERS = 5;
	
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
				return;
			}
		}
		System.out.println("No item with id " + ind);
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
	
	public String toString() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Media get(int index) {
		return itemsOrdered.get(index);
	}
	
	public int getNbOrdered() {
		return itemsOrdered.size();
	}
	
}

