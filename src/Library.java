import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Artist> artists;
    private final List<Album> albums;
    private final List<Song> songs;
    private final List<User> users;

    public Library() {
        this.artists = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addArtist(Artist artist) { artists.add(artist); }
    public void addAlbum(Album album) { albums.add(album); }
    public void addSong(Song song) { songs.add(song); }
    public void addUser(User user) { users.add(user); }

    public List<Song> searchSongs(String query) {
        String q = query.toLowerCase();
        return songs.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(q)
                        || s.getArtist().getName().toLowerCase().contains(q)
                        || (s.getAlbum() != null && s.getAlbum().getTitle().toLowerCase().contains(q)))
                .collect(Collectors.toList());
    }

    public List<Artist> searchArtists(String query) {
        String q = query.toLowerCase();
        return artists.stream()
                .filter(a -> a.getName().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Album> searchAlbums(String query) {
        String q = query.toLowerCase();
        return albums.stream()
                .filter(a -> a.getTitle().toLowerCase().contains(q) || a.getArtist().getName().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Song> getAllSongs() { return songs; }
    public List<User> getUsers() { return users; }
}