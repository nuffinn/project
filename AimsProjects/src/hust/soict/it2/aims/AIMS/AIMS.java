package hust.soict.it2.aims.AIMS;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.it2.aims.media.Book;
import hust.soict.it2.aims.media.CompactDisc;
import hust.soict.it2.aims.media.DigitalVideoDisc;
import hust.soict.it2.aims.media.MemoryDaemon;
import hust.soict.it2.aims.order.Order;

public class AIMS {
	public static void main(String[] args) {
		MemoryDaemon mmr = new MemoryDaemon();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("alladin","fantasy","james",124,20,001);
		CompactDisc cd1 = new CompactDisc(007);
		Book book1 = new Book("Oliver Twist","Adventure",40,005);
		
		showMenu();
		
		ArrayList<Order> orderList = new ArrayList<>();
		int index = 0;
		orderList.add(new Order(index));
		int a;
		Scanner scanner = new Scanner(System.in);
		
		do {
			showMenu();
			a = scanner.nextInt();
			switch (a) {
				case 1 :{
					index++;
					orderList.add(new Order(index));
					break;
				}
				
				case 2 :{
					System.out.println("pick a type :\n1.DVD\n2.CD\n3.Book");
					int temp = scanner.nextInt();
			        if (temp == 1) {
			        	orderList.get(index).addDVD(dvd1);
			        	System.out.println("Do you want to play: " + orderList.get(index).getItemById(dvd1.getId()).getTitle()
			        		+ "\n0:No   1.Yes");
			        	int temp1 = scanner.nextInt();
			        	if(temp1== 1) dvd1.play();
			        	break;
			        }
			        if (temp == 2) {
			        	orderList.get(index).addCD(cd1);
			        	System.out.println("Do you want to play: " + cd1.getTitle()
		        		+ "\n0:No   1.Yes");
			        	int temp1 = scanner.nextInt();
			        	if(temp1== 1) cd1.play();
			        	break;
			        }
			        if (temp == 3) {
			        	orderList.get(index).addBook(book1);
			        	break;
			        }
				}
				
				case 3:{
					System.out.println("id :");
					int ind = scanner.nextInt();
					orderList.get(index).removeById(ind);
					break;
				}
				
				case 4:{
					orderList.get(index).printItems();
					break;
				}
			}
		} while (a!=0);
		
		System.exit(0);
	}
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}

}
