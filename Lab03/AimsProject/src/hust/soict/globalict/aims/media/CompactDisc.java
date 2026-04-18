// LAB 3 SESSION 10.3

package hust.soict.globalict.aims.media;

import java.util.ArrayList;

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
        
     // CÀI ĐẶT HÀM PLAY CHO CD 
     @Override
     public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD total length: " + this.getLength());
        // Lặp qua từng track và gọi hàm play() của từng cái
        for (Track track : tracks) {
            track.play(); 
        }
    }
}    