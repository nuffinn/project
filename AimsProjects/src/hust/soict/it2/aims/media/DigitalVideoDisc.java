package hust.soict.it2.aims.media;

public class DigitalVideoDisc extends Disc implements Playable,Comparable<DigitalVideoDisc> {
	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super(title, category, cost, length, director, id);
	}
	public DigitalVideoDisc(String title, String category, String director) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean search(String tit) {
		String[] token1 = tit.split(" ");
		String[] token2 = this.title.split(" ");
		int i,j,c=0;
		for (i=0; i< token1.length; i++) {
			for (j=0; j< token2.length; j++) {
				if(token1[i].equals(token2[j])) {
					c++;
					break;
				}
			}
		}
		if (c!=token1.length) return false; 
		return true;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}
	
	public int compareTo(DigitalVideoDisc dvd) {
		int temp =(int)(this.cost - dvd.cost);
		return temp;
	}
	
}