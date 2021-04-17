package hust.soict.it2.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
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
	
}