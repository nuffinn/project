package hust.soict.it2.aims.media;

public class Disc extends Media {
	
	protected int length;
	protected String director;

	public Disc() {
		super();
	}
	
	public Disc(String title, String category, float cost, int id) {
		super(title, category, cost, id);
	}
	
	public Disc(String title, String category, float cost, int length, String director, int id) {
		super(title, category, cost, id);
		this.length = length;
		this.director = director;
	}
	
	public Disc(int length, String director) {
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

}
