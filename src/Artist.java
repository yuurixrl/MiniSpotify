import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String name;
    private final List<Album> albums;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Album> getAlbums() { return albums; }

    public void addAlbum(Album album) {
        if (!albums.contains(album)) {
            albums.add(album);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}