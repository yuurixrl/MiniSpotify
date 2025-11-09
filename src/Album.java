import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String title;
    private final Artist artist;
    private final int year;
    private final List<Song> songs;

    public Album(String id, String title, Artist artist, int year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.songs = new ArrayList<>();
        if (artist != null) artist.addAlbum(this);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Artist getArtist() { return artist; }
    public int getYear() { return year; }
    public List<Song> getSongs() { return songs; }

    public void addSong(Song song) {
        if (!songs.contains(song)) songs.add(song);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", artist.getName(), title, year);
    }
}