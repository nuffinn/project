package aims_gui;

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
	
	public boolean equals(Media med) {
		if (this.id == med.id) return true;
		else return false;
	}
}
