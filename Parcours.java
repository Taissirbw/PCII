import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Parcours {

    public static ArrayList<Point> points = new ArrayList<>();
    public static Affichage affichage;
    public static Etat etat;

    public static final Random rand = new Random();
    public static final Random rand2 = new Random();

    public Parcours(Etat e){
        etat = e;
        affichage = this.etat.getAffichage();
        createParcours();
    }

    public void createParcours(){
        Point debut = new Point();
        int x = this.affichage.getBordX() + this.affichage.getOvalWidth()/2;
        int y = this.affichage.hauteur - this.affichage.getOvalHeight()/2;
        debut.setLocation(x, y);
        this.points.add(debut);

        Random rand = new Random();
        while(x < affichage.getLargeur() + 50){
            int r = rand.nextInt(100);
            if (r<50) r += 50;
            x = x + r;
            y = rand.nextInt(200) + this.etat.getTaille();
            Point p = new Point(x, y);
            this.points.add(p);
        }
    }

    public void retirerPoints() {
        if (this.points.get(0).getX() < 0 && this.points.get(1).getX() < 0) {
            this.points.remove(0);
        }
    }

    public ArrayList<Point> updateParcours(){
        ArrayList<Point> upt = this.points;
        Iterator<Point> iter = upt.iterator();

        while(iter.hasNext()) {
            Point p = iter.next();
            p.move(p.x - 5, p.y);
            if(p.x < - 200) iter.remove();
        }
        //upt.removeIf()

        Random rand = new Random();
        int x = upt.get(upt.size() - 1).x;
        while(x < affichage.getLargeur() + 50){
            x = x + 50 + rand.nextInt(100);
            Point p = new Point(x, rand.nextInt(200) + this.etat.getTaille());
            upt.add(p);
        }
        return upt;
    }

    public void testParcours(){
        for (Point p : points
             ) {
            System.out.print("Abscisse " + p.getX() + " Ordonnée " + p.getY() + "\n");
        }
    }

    public static ArrayList<Point> getPoints() {
        return points;
    }
}
