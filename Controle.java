import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**Classe permettant de faire le lien entre le modèle et l'affichage. Controle est lié à la fenetre affichée par le
 * programme et est attentif aux action de l'utilisateur.*/
public class Controle implements MouseListener {

    Affichage affichage;
    Etat etat;

    public Controle(Affichage a, Etat e){
        affichage = a;
        etat = e;
    }

    /**----Methodes du MousseListener----*/
    /**Réaction en cas d'interraction de l'utilisateur, ici un clic de souris.
     * On informe le modèle d'une modification à effectuer puis on actualise l'affichage, afin que celui-ci soit
     * en adéquation avec la dernière mise à jour du modèle.*/
    @Override
    public void mouseClicked(MouseEvent e) {
        etat.jump();
        affichage.repaint();
    }

    /**Pour tous les autres évènements enregistrés par la souris, on ne fait rien.*/
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

}
