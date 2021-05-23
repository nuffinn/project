package hust.soict.it2.aims.media;

public abstract class Media {

	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public Media(String title) {
		this.title = title;
	}
	
	public Media(String title, String category) {
		this(title);
		this.category = category;
		
	}
	
	public Media(String title, String category, float cost, int id) {
		this(title, category);
		this.cost = cost;
		this.id = id;
		
	}

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}
	
	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public boolean equals(Media med1, Media med2) {
		try {
			if(med1.title==med2.title) {
				return true;
			}else return false;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
