package hust.soict.it2.aims.AIMS;

import hust.soict.it2.aims.media.DigitalVideoDisc;
import hust.soict.it2.aims.order.Order;

public class AIMS {
	public static void main(String[] args) {
		Order anOrder = new Order();
		Order anOrder1 = new Order();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		anOrder.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("Geogre Lucas");
		dvd2.setLength(124);
		
		anOrder.addMedia(dvd2);
		anOrder.printItems();
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin");
		dvd3.setCategory("animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		anOrder1.addMedia(dvd3);
		anOrder1.printItems();
	}

}
