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