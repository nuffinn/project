package hust.soict.it2.aims.media;

public class Track implements Playable {

	private String title;
	private int length;
	
	public Track() {
		super();
	}
	
	public void play() {
		System.out.println("Playing : " + this.getTitle());
		System.out.println("length: " + this.getLength());
		}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

}
