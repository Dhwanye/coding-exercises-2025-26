package structural.adapter;

interface MediaPlayer { void play(String filename); }

class AdvancedMediaPlayer {
    public void playMp4(String filename) { System.out.println("Playing mp4 file: " + filename); }
}

class MediaAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();
    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp4")) advancedMediaPlayer.playMp4(filename);
        else System.out.println("Unsupported format: " + filename);
    }
}

class AudioPlayer implements MediaPlayer {
    private final MediaAdapter adapter = new MediaAdapter();
    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp3")) System.out.println("Playing mp3 file: " + filename);
        else adapter.play(filename);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();
        player.play("song.mp3");
        player.play("video.mp4");
    }
}