import greenfoot.*;

public class Police extends Actor
{
    private int moveCounter = 0;

    public void act()
    {
        // Panggil method untuk bergerak secara random
        moveRandomly();
    }

    private void moveRandomly()
    {
        // Mengubah arah setiap 50 aktor langkah
        if (moveCounter % 50 == 0) {
            int randomDirection = Greenfoot.getRandomNumber(4);
            switch (randomDirection) {
                case 0: setRotation(0); break;   // Bergerak ke kanan
                case 1: setRotation(90); break;  // Bergerak ke bawah
                case 2: setRotation(180); break; // Bergerak ke kiri
                case 3: setRotation(270); break; // Bergerak ke atas
            }
        }

        // Bergerak maju 1 langkah
        move(2);

        // Cek jika Police mencapai tepi dunia dan membalik arah
        if (isAtEdge()) {
            setRotation(getRotation() + 180);
        }

        moveCounter++;
    }
}