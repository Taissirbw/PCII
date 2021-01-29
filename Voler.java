public class Voler extends Thread {

    public static Etat etat;

    public Voler(Etat e) {
        etat = e;
    }

    @Override
    public void run() {
        while (true) {
            try {
                etat.moveDown();
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
