package aims_gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media implements Comparable<Book> {
	
	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	public List<String> contentCount ;
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
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

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void processContent() {
		List<String> list = Arrays.asList(content.split("\\W+"));
		for (String s: list)
        {
            Integer count = wordFrequency.get(s);
            if (count == null) {
                count = 0;
            }
 
            wordFrequency.put(s, count + 1);
        }
	}

	public void setContent(String str) {
		content = str;
		this.processContent();
	}
	
	public String toString() {
		return content + "\ncontent length:" + wordFrequency.size() + wordFrequency +"\n" + title +
				"\n" + cost + "\n" + category + "\nid:" + id ;
	}
	
}
