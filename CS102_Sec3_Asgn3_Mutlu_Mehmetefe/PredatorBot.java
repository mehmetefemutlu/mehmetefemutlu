public class PredatorBot extends Robot {

    public PredatorBot(){
        super();

        health = Math.random()+2;
        attack = Math.random()+2;
        speed = (Math.random()/2)+0.5;

        name = "P" + productionNumber;
    }

    public void attack(Simulation s){}
    
}
