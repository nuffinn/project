package hust.soict.it2.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

	public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(int id) {
		this.id = id;
	}
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("This track has already been added.");
		} else tracks.add(track);
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println(track.getTitle() + " has been removed.");
		} else System.out.println(track.getTitle() + " didn't exist in the list.");
	}
	
	public int getLength() {
		int total=0;
		for (int i = 0; i < tracks.size(); i++) {
			total += tracks.get(i).getLength();
		}
		return total;
	}
	
	public void play() {
		for (int i=0; i<tracks.size(); i++) {
			tracks.get(i).play();
		}
	}
	
}
