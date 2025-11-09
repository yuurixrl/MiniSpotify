public class DataLoader {
    public static void loadSampleData(Library lib) {
        Artist a1 = new Artist("ar1", "The Example Band");
        Artist a2 = new Artist("ar2", "Solo Artist");

        Album al1 = new Album("al1", "First Album", a1, 2020);
        Album al2 = new Album("al2", "Acoustic Sessions", a2, 2021);

        Song s1 = new Song("s1", "Example Track", a1, al1, 210);
        Song s2 = new Song("s2", "Another Song", a1, al1, 185);
        Song s3 = new Song("s3", "Acoustic One", a2, al2, 145);
        Song s4 = new Song("s4", "Lonely Road", a2, null, 200);

        al1.addSong(s1); al1.addSong(s2);
        al2.addSong(s3);

        lib.addArtist(a1); lib.addArtist(a2);
        lib.addAlbum(al1); lib.addAlbum(al2);
        lib.addSong(s1); lib.addSong(s2); lib.addSong(s3); lib.addSong(s4);

        User u1 = new User("u1", "yuri");
        Playlist p1 = u1.createPlaylist("p1", "Minhas favoritas");
        p1.addSong(s1);
        p1.addSong(s3);

        lib.addUser(u1);
    }
}