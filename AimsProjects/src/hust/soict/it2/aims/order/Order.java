package hust.soict.it2.aims.order;

import java.util.Random;

import hust.soict.it2.aims.disc.DigitalVideoDisc;
import hust.soict.it2.aims.utils.MyDate;

public class Order {
	public Order() {
		super();
		nbOrders++;
		if(nbOrders == MAX_LIMITTED_ORDERS) System.out.println("Max number of orders reached");
	}

	public static final int MAX_NUMBER_ORDERED = 10;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	private int qtyOrdered = 0;
	
	private MyDate dateOrdered = new MyDate();
	
	public static final int MAX_LIMITTED_ORDERS = 5;
	
	private static int nbOrders = 0;
	
	public void printItems(){
		System.out.println("***********************Order***********************");
		System.out.println("Date: "); dateOrdered.printDate();
		System.out.println("\nOrdered items: ");
		int u;
		for (u=0; u < qtyOrdered; u++) {
			int z = u + 1;
			System.out.println(z + ". DVD"  + itemsOrdered[u].getTitle() + "-" + itemsOrdered[u].getCategory()+ "-" + itemsOrdered[u].getDirector() + "-" + itemsOrdered[u].getLength() + ": " + itemsOrdered[u].getCost() + "$");
		}
		float c = totalCost();
		System.out.println("Total cost: " + c);
		System.out.println("***************************************************");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full");
			return;
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		if (qtyOrdered == MAX_NUMBER_ORDERED - 1) {
			System.out.println("The order is almost full");
		}
		return;
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int s = 0;
		while (dvdList[s].equals(null)) {
			if (qtyOrdered >= MAX_NUMBER_ORDERED) {
				System.out.println("The order is full");
				break;
			}
			itemsOrdered[qtyOrdered] = dvdList[s];
			qtyOrdered++;
			s++;
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 ) {
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full ," + dvd1.getTitle() + " and " + dvd2.getTitle() + " cannot be added.");
			return;
		}
		itemsOrdered[qtyOrdered] = dvd1;
		qtyOrdered++;
		if (qtyOrdered >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full ," + dvd2.getTitle() + " cannot be added.");
			return;
		}
		itemsOrdered[qtyOrdered] = dvd2;
		qtyOrdered++;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc  disc) {
		int x, c ;
		c = 0;
		for (x=0; x < qtyOrdered; x++) {
			if ( itemsOrdered[x].equals(disc) ) {
				itemsOrdered[x] = itemsOrdered[qtyOrdered-1];
				itemsOrdered[qtyOrdered-1] = null;
				System.gc();
				qtyOrdered--;
				c++;
				System.out.println("Item " + disc.getTitle() + " has been removed");
				return;
			}
		}
		if (c == 0) {
			System.out.println("Item not found");
			return;
		}
	}
	
	public float totalCost() {
		int y;
		float total = 0 ;
		total =0;
		for (y = 0; y < qtyOrdered; y++) {
			total += itemsOrdered[y].getCost();
		}
		return total;
	}
	
	public DigitalVideoDisc getALuckyItem() {
		Random rd = new Random();
		int nb1 = rd.nextInt(qtyOrdered);
		DigitalVideoDisc temp = itemsOrdered[nb1];
		for (int i = nb1; i <qtyOrdered; i++) {
			if(i==qtyOrdered-1) break; 
			itemsOrdered[i]= itemsOrdered[i+1];
		}
		qtyOrdered--;
		System.gc();
		return temp;
	}
}

