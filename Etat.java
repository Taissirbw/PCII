public class Etat {

    /**On définit une cosntante pour la valeur d'un saut.*/
    private static final int saut = 40;
    private static int hauteurMAX;

    private static int taille;
    private int hauteur;
    private static Affichage affichage;
    private static Parcours parcours;

    /**Constructeur de l'objet. On considère que la hauteur 0 correspond à la plus basse position sur l'axe y.
     * On s'assurera lors de l'affichage de prendre en compte ce choix.*/
    public Etat(){
        hauteur = 0;
    }

    /**Saut de l'objet : Modification de l'attribut de hauteur de l'objet.*/
    public void jump(){
        if (hauteur + taille < hauteurMAX) hauteur = hauteur + saut;
    }

    public void moveDown(){
        if (hauteur > 0) hauteur = hauteur - 5;
        affichage.revalidate();
        affichage.repaint();
    }

    /**Fonction d'interface permettant aux autre classes d'acceder à l'attribut hauteur de l'objet.*/
    public int getHauteur(){ return hauteur; }
    public int getTaille(){ return taille; }
    public Affichage getAffichage(){
        return this.affichage;
    }
    public Parcours getParcours(){
        return this.parcours;
    }

    public void init(int x, Affichage aff){
        hauteurMAX = x;
        taille = x/5;
        affichage = aff;
        parcours = new Parcours(this);
        parcours.testParcours();
        Avancer avancer = new Avancer(parcours);
        avancer.start();
    }

}
