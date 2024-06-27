import greenfoot.*;

public class Mc extends Actor {
    private long lastStepSoundTime; // Variabel untuk menyimpan waktu terakhir suara diputar
    private final long stepSoundDelay = 200; // Delay dalam milidetik (0.2 detik)

    public void act() {
        long currentTime = System.currentTimeMillis(); // Mendapatkan waktu saat ini

        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
            if (currentTime - lastStepSoundTime >= stepSoundDelay) {
                Greenfoot.playSound("step.wav");
                lastStepSoundTime = currentTime; // Update waktu terakhir suara diputar
            }
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
            if (currentTime - lastStepSoundTime >= stepSoundDelay) {
                Greenfoot.playSound("step.wav");
                lastStepSoundTime = currentTime; // Update waktu terakhir suara diputar
            }
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
            if (currentTime - lastStepSoundTime >= stepSoundDelay) {
                Greenfoot.playSound("step.wav");
                lastStepSoundTime = currentTime; // Update waktu terakhir suara diputar
            }
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
            if (currentTime - lastStepSoundTime >= stepSoundDelay) {
                Greenfoot.playSound("step.wav");
                lastStepSoundTime = currentTime; // Update waktu terakhir suara diputar
            }
        }

        // Handle interactions with other objects
        if (isTouching(KentangBesar.class)) {
            Score.add(2);
            removeTouching(KentangBesar.class);

            if (getWorld() instanceof MyWorld2) {
                ((MyWorld2) getWorld()).decreaseBombAndRespawn();
            }
            if (getWorld() instanceof MyWorld3) {
                ((MyWorld3) getWorld()).decreaseBombAndRespawn();
            }
        }

        if (isTouching(Kentang.class)) {
            Score.add(1);
            removeTouching(Kentang.class);
            Greenfoot.playSound("sfx_makan_2.wav");
            if (getWorld() instanceof MyWorld2) {
                ((MyWorld2) getWorld()).decreaseBombAndRespawn();
            }
            if (getWorld() instanceof MyWorld3) {
                ((MyWorld3) getWorld()).decreaseBombAndRespawn();
            }
        }

        if (isTouching(Police.class)) {
            Greenfoot.playSound("sfx_polisi.wav");
            ((MyWorld3) getWorld()).gameOver();
        }

        if (isTouching(Bomb.class)) {
            Greenfoot.playSound("bomb.wav");
            if (getWorld() instanceof MyWorld3) {
                ((MyWorld3) getWorld()).gameOver();
            } else if (getWorld() instanceof MyWorld2) {
                ((MyWorld2) getWorld()).gameOver();
            }
        }

        if (Score.getScore() >= 5 && getWorld() instanceof MyWorld) {
            Greenfoot.setWorld(new MyWorld2());
        }
        if (Score.getScore() >= 10 && getWorld() instanceof MyWorld2) {
            Greenfoot.setWorld(new MyWorld3());
        }
    }
}
