package hust.soict.it2.aims.media;

public class TestingMediaCompareTo {

	public static void main(String[] args) {
		java.util.Collection collection = new java.util.ArrayList();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("alladin","fantasy","james",124,20,001);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Titanic","documentary","henry",119,10,002);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Lion King","animation","joey",156,5,003);
		
		collection.add(dvd2);
		collection.add(dvd1);
		collection.add(dvd3);
		
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The DVDs curently  in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		java.util.Collections.sort((java.util.List)collection);
		iterator = collection.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("--------------------------------------");
	}
}
