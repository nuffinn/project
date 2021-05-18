package aims_gui;

public class Track implements Playable,Comparable<Track> {

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
	
	public boolean equals(Track track) {
		if (this.title == track.title && this.length == track.length) return true;
		else return false;
	}

	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
