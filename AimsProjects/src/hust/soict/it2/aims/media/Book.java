package hust.soict.it2.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost, int id) {
		super(title, category,cost,id);
	}
	
	public Book(String title, String category, ArrayList<String> authors) {
		super(title, category);
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			return;
		} else authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		} else return;
	}

}
