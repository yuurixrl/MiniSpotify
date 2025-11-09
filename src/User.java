import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String username;
    private final List<Playlist> playlists;
    private final List<Artist> followedArtists;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.playlists = new ArrayList<>();
        this.followedArtists = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public List<Playlist> getPlaylists() { return playlists; }
    public List<Artist> getFollowedArtists() { return followedArtists; }

    public Playlist createPlaylist(String id, String name) {
        Playlist p = new Playlist(id, name);
        playlists.add(p);
        return p;
    }

    public void followArtist(Artist artist) {
        if (!followedArtists.contains(artist)) followedArtists.add(artist);
    }

    public void unfollowArtist(Artist artist) {
        followedArtists.remove(artist);
    }

    @Override
    public String toString() {
        return username;
    }
}