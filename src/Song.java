import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String title;
    private final Artist artist;
    private final Album album;
    private final int durationSeconds; // duração em segundos

    public Song(String id, String title, Artist artist, Album album, int durationSeconds) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationSeconds = durationSeconds;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Artist getArtist() { return artist; }
    public Album getAlbum() { return album; }
    public int getDurationSeconds() { return durationSeconds; }

    public String getDurationString() {
        int m = durationSeconds / 60;
        int s = durationSeconds % 60;
        return String.format("%d:%02d", m, s);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) [%s]", artist.getName(), title,
                album != null ? album.getTitle() : "Single", getDurationString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}