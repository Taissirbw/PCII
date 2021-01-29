import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**Classe en charge de l'affichage à l'écran ddes composants de la fenetre (lorsque c'est necessaire)*/
public class Affichage extends JPanel {

    private Etat etat;
    private Parcours parcours;
    /****** Constantes *****/
    /** Dimensions de la fenêtre*/
    public static final int largeur = 400;
    public static final int hauteur = 300;


    /** Dimensions de l'objet. Pour définir un oval, on a besoin des coordonnées en x des bords (la coordonée en y
     * étan gérée par l'attribut de hauteur de l'objet, dans la classe etat)
     * du dessin, ainsi que de sa largeur et hauteur.*/
    private static final int bordX = 30;
    private static final int ovalWidth = largeur/20;
    private static int ovalHeight = hauteur/5;


    /**Constructeur*/
    public Affichage(Etat e){
        etat = e;
        e.init(hauteur, this);
        ovalHeight = hauteur/5;
        setPreferredSize(new Dimension(largeur, hauteur));
    }

    private void ligneBrisee(Graphics g){
        ArrayList<Point> p = this.etat.getParcours().getPoints();
        for (int i = 0; i < p.size() - 1 ; i++){
            Point a = p.get(i);
            Point b = p.get(i+1);
            g.drawLine(a.x, a.y, b.x, b.y);
        }
    }

    /**Dessin d'un élèment.*/
    @Override
    public void paint(Graphics g){
        super.paint(g);
        /* Pour décrire la hauteur dans la classe état de manière plus naturelle (bas = 0), on effectue une
        * une soustraction avec les données de hauteur dans le deuxième paramètre. */
        g.drawOval(bordX, hauteur - ovalHeight - etat.getHauteur(), ovalWidth, ovalHeight);
        ligneBrisee(g);
    }

    public int getLargeur(){ return largeur; }
    public int getOvalWidth(){return ovalWidth;}
    public int getOvalHeight(){return ovalHeight;}
    public int getHauteur() { return hauteur; }
    public int getBordX(){return bordX;}
    //public int getBordY(){return bordX;}
}
