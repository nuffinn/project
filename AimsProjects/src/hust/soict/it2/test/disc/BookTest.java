package hust.soict.it2.test.disc;

import hust.soict.it2.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("Norwegian wood","Haruki Murakami",100,123);
		book1.setContent("The novel is set in late 1960s Tokyo during a period when Japanese students,"
				+ " like those of many other nations, were protesting against the established order");
		System.out.println(book1.toString());

	}

}
