import greenfoot.*;

public class Score extends Actor {
    private static int score = 0; // Variabel untuk menyimpan skor

    public Score() {
        updateImage();
    }

    // Menambahkan nilai ke skor
    public static void add(int value) {
        score += value;
    }

    // Method untuk mereset skor
    public static void reset() {
        score = 0;
    }

    // Method untuk mendapatkan nilai skor saat ini
    public static int getScore() {
        return score;
    }

    // Memperbarui tampilan gambar skor
    public void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLACK));
    }

    // Method yang dipanggil setiap frame
    public void act() {
        updateImage();
    }
}
