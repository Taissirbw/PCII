public class Avancer extends Thread {
    public static final int vitesse = 100;

    private Parcours parcours;

    public Avancer(Parcours p ){
        this.parcours = p;
    }

    @Override
    public void run(){
        while(true){
            try{
                parcours.updateParcours();
                parcours.retirerPoints();
                Thread.sleep(vitesse);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}