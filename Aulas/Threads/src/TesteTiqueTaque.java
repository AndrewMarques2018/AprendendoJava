public class TesteTiqueTaque {
    public static void main(String[] args) {

        TiqueTaque tt = new TiqueTaque();
        ThreadTiqueTaque tique = new ThreadTiqueTaque(tt, "Tique");
        ThreadTiqueTaque taque = new ThreadTiqueTaque(tt, "Taque");

        try {
            tique.t.join();
            taque.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
