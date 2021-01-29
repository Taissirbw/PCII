import javax.swing.*;

/**Classe principale du programme. C'est ici qu'on crée des instances du modèle, de la vue et du contrôleur
 * puis qu'on les relie entre eux et qu'on crée la fenetre à afficher.*/
public class Main {
    
    public static void main(String [] args){
        /** On crée respectivement un modèle (etat), une vue (affichage) et un contrôleur (controle).*/
        Etat etat = new Etat();
        Affichage affichage = new Affichage(etat);
        Controle controle = new Controle(affichage, etat);
        Voler voler = new Voler(etat);



        /** On crée une fênetre à laquelle on ajoute des composant affichage et controle.*/
        JFrame fenetre = new JFrame("Flappy Oval");
        fenetre.add(affichage);
        fenetre.addMouseListener(controle);
        voler.start();


        /** On s'assure que la fenêtre sera bien visible et on définit le comportement du programme lorsque la fenêtre
         * est fermée.*/
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
