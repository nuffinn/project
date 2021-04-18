package hust.soict.it2.aims.AIMS;

import hust.soict.it2.aims.media.DigitalVideoDisc;
import hust.soict.it2.aims.media.Media;
import hust.soict.it2.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		DigitalVideoDisc disc = new DigitalVideoDisc("Potter Harry");
		System.out.print(disc.search("Harry Potter"));
		
		Order anOrder2 = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		anOrder2.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("Geogre Lucas");
		dvd2.setLength(124);
		
		anOrder2.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin");
		dvd3.setCategory("animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		anOrder2.addMedia(dvd3);
		System.out.println("\ntotal cost: " + anOrder2.totalCost());
		Media disk = anOrder2.getALuckyItem();
		System.out.println(disk.getTitle() +" is free\ntotal cost is: " + anOrder2.totalCost());
		
	}

}
