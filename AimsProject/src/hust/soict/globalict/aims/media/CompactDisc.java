// LAB 3 SESSION 10.3 | LAB05 SESSION 10.4

package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() { 
        return artist; 
    }

    // Thêm track vào danh sách (có kiểm tra trùng title)
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        }
    }

    // Xóa track khỏi danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
        }
    }

    // Tổng độ dài CD = tổng độ dài các Track
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
        
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            System.out.println("CD total length: " + this.getLength());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD '" + this.getTitle() + "' length is non-positive!");
        }
    }
     
     public String toString() {
    	 return "CD - " + getTitle() + " - " + getCategory() + " - Artist: " + getArtist() + " - Length: " + getLength() + " - Cost: " + getCost() + " $";
     }
}    