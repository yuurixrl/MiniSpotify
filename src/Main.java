import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();
    private static final Player player = new Player();
    private static User currentUser = null;

    public static void main(String[] args) {
        DataLoader.loadSampleData(library);
        currentUser = library.getUsers().get(0);
        System.out.println("Bem-vindo ao MiniSpotify (simulado)!");
        System.out.println("Usuário atual: " + currentUser.getUsername());
        loop();
    }

    private static void loop() {
        boolean running = true;
        while (running) {
            showMenu();
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1": listAllSongs(); break;
                case "2": searchSongs(); break;
                case "3": showPlaylists(); break;
                case "4": createPlaylist(); break;
                case "5": addSongToPlaylist(); break;
                case "6": playPlaylist(); break;
                case "7": playerControls(); break;
                case "0": running = false; break;
                default: System.out.println("Opção inválida."); break;
            }
        }
        System.out.println("Saindo. Até logo!");
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Listar todas as músicas");
        System.out.println("2 - Buscar músicas");
        System.out.println("3 - Minhas playlists");
        System.out.println("4 - Criar playlist");
        System.out.println("5 - Adicionar música em playlist");
        System.out.println("6 - Tocar playlist");
        System.out.println("7 - Controles do player (play/pause/next/prev/queue)");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void listAllSongs() {
        List<Song> songs = library.getAllSongs();
        if (songs.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i+1) + ". " + songs.get(i).toString());
        }
    }

    private static void searchSongs() {
        System.out.print("Termo de busca: ");
        String q = scanner.nextLine();
        List<Song> results = library.searchSongs(q);
        if (results.isEmpty()) {
            System.out.println("Nenhum resultado.");
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i+1) + ". " + results.get(i).toString());
        }
    }

    private static void showPlaylists() {
        List<Playlist> playlists = currentUser.getPlaylists();
        if (playlists.isEmpty()) {
            System.out.println("Você não tem playlists.");
            return;
        }
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + ". " + playlists.get(i).toString());
        }
    }

    private static void createPlaylist() {
        System.out.print("Nome da nova playlist: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Nome vazio."); return; }
        String id = "p" + (currentUser.getPlaylists().size() + 1);
        currentUser.createPlaylist(id, name);
        System.out.println("Playlist criada: " + name);
    }

    private static void addSongToPlaylist() {
        showPlaylists();
        System.out.print("Escolha playlist (número): ");
        int pidx = Integer.parseInt(scanner.nextLine()) - 1;
        if (pidx < 0 || pidx >= currentUser.getPlaylists().size()) { System.out.println("Índice inválido."); return; }
        Playlist p = currentUser.getPlaylists().get(pidx);

        listAllSongs();
        System.out.print("Escolha música (número): ");
        int sidx = Integer.parseInt(scanner.nextLine()) - 1;
        if (sidx < 0 || sidx >= library.getAllSongs().size()) { System.out.println("Índice inválido."); return; }
        Song s = library.getAllSongs().get(sidx);

        p.addSong(s);
        System.out.println("Adicionado: " + s.getTitle() + " -> " + p.getName());
    }

    private static void playPlaylist() {
        showPlaylists();
        System.out.print("Escolha playlist (número): ");
        int pidx = Integer.parseInt(scanner.nextLine()) - 1;
        if (pidx < 0 || pidx >= currentUser.getPlaylists().size()) { System.out.println("Índice inválido."); return; }
        Playlist p = currentUser.getPlaylists().get(pidx);
        player.setQueue(p.getSongs());
        player.play();
    }

    private static void playerControls() {
        System.out.println("Comandos: play / pause / next / prev / queue / stop");
        while (true) {
            System.out.print("cmd> ");
            String cmd = scanner.nextLine().trim().toLowerCase();
            switch (cmd) {
                case "play": player.play(); break;
                case "pause": player.pause(); break;
                case "next": player.next(); break;
                case "prev": player.previous(); break;
                case "queue": player.showQueue(); break;
                case "stop": return;
                default: System.out.println("Comando inválido."); break;
            }
        }
    }
}
