import java.util.List;

public class Player {
    private List<Song> queue;
    private int currentIndex = -1;
    private boolean isPlaying = false;

    public Player() {}

    public void setQueue(List<Song> songs) {
        this.queue = songs;
        this.currentIndex = songs == null || songs.isEmpty() ? -1 : 0;
    }

    public Song getCurrent() {
        if (queue == null || currentIndex < 0 || currentIndex >= queue.size()) return null;
        return queue.get(currentIndex);
    }

    public void play() {
        Song s = getCurrent();
        if (s == null) {
            System.out.println("Fila vazia.");
            return;
        }
        isPlaying = true;
        System.out.println("▶ Tocando: " + s.toString());
    }

    public void pause() {
        if (!isPlaying) {
            System.out.println("Player já pausado.");
            return;
        }
        isPlaying = false;
        System.out.println("|| Pausado.");
    }

    public void next() {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Nada na fila.");
            return;
        }
        if (currentIndex < queue.size() - 1) {
            currentIndex++;
            play();
        } else {
            System.out.println("Fim da fila.");
        }
    }

    public void previous() {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Nada na fila.");
            return;
        }
        if (currentIndex > 0) {
            currentIndex--;
            play();
        } else {
            System.out.println("Início da fila.");
        }
    }

    public void showQueue() {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            String mark = (i == currentIndex) ? ">> " : "   ";
            System.out.println(mark + (i+1) + ". " + queue.get(i).toString());
        }
    }
}