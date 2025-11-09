import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private String name;
    private final List<Song> songs;

    public Playlist(String id, String name) {
        this.id = id;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Song> getSongs() { return songs; }

    public void addSong(Song song) {
        if (!songs.contains(song)) songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void clear() {
        songs.clear();
    }

    @Override
    public String toString() {
        return String.format("Playlist '%s' (%d músicas)", name, songs.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(id, playlist.id);
    }
}