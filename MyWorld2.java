import greenfoot.*;  
import java.util.*;

public class MyWorld2 extends World {
    private int bombCount = 3;
    private int KbCount = 0; // Counter for KentangBesar
    private boolean gameOver = false;
    private int spawnCounter = 0;

    public MyWorld2() {    
        super(600, 400, 1); 
        prepare();
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
        
        // Add only up to 2 KentangBesar initially
        while (KbCount < 2) {
            addRandomKentangBesar();
        }
        
        for (int i = 0; i < 3; i++) {
            addRandomBomb();
        }
    }
    
    public void act() {
        if (!gameOver) {
            if (spawnCounter > 100) {
                spawnCounter = 0;
                addRandomKentang();
                // Only add KentangBesar if KbCount is less than 2
                if (KbCount < 2) {
                    addRandomKentangBesar();
                }
            }
            spawnCounter++;
        }
    }

    public void addRandomBomb() {
        Bomb bomb = new Bomb();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(bomb, x, y);
        bombCount++;
    }

    private void addRandomKentang() {
        Kentang kentang = new Kentang();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(kentang, x, y);
    }
    
    private void addRandomKentangBesar() {
        KentangBesar kentangbesar = new KentangBesar();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(kentangbesar, x, y);
        KbCount++; // Increment KentangBesar count
    }

    public void removeRandomBomb() {
        List<Bomb> bombs = getObjects(Bomb.class);
        if (!bombs.isEmpty()) {
            Bomb bomb = bombs.get(Greenfoot.getRandomNumber(bombs.size())); // Get a random bomb
            removeObject(bomb);
            bombCount--;
        }
    }

    public void decreaseBombAndRespawn() {
        removeRandomBomb();
        if (bombCount > 0) {
            addRandomBomb();
        }
    }

    public void gameOver() {
        gameOver = true;
        showText("Game Over!", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}
