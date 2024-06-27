import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class MyWorld extends World {
    private int spawnCounter = 0;
    private boolean gameOver = false;
    private static int score = 0;
    private GreenfootSound bgm;
    private boolean isPlayingSound = false;
    private boolean isMuted = false;

    public MyWorld() {
        super(600, 400, 1);
        Score.reset();
        prepare();
        bgm = new GreenfootSound("bgm.wav");
        bgm.setVolume(50);
        bgm.playLoop();
    }

    private void prepare() {
        Mc mc = new Mc();
        addObject(mc, 298, 324);
        mc.setLocation(301, 348);

        Score score = new Score();
        addObject(score, 50, 10);

        for (int i = 0; i < 5; i++) {
            addRandomKentang();
        }
    }

    public void act() {
        if (!gameOver) {
            if (spawnCounter > 100) {
                spawnCounter = 0;
                addRandomKentang();
            }
            spawnCounter++;
        } else {
            bgm.stop();  // Hentikan BGM saat permainan selesai
        }

        // Check for mute toggle
        if (Greenfoot.isKeyDown("m")) {
            isMuted = !isMuted;
            if (isMuted) {
                bgm.setVolume(0);
            } else {
                bgm.setVolume(50);
            }
            Greenfoot.delay(10); // Tambahkan sedikit penundaan untuk mencegah toggling cepat
        }
    }

    private void addRandomKentang() {
        Kentang kentang = new Kentang();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(kentang, x, y);
    }

    public void gameOver() {
        gameOver = true;
        showText("Game Over!", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
        bgm.stop();  // Hentikan BGM saat permainan selesai
    }
}
