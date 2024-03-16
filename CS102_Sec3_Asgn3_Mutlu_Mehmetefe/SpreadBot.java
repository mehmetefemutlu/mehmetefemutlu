public class SpreadBot extends Robot {

    public SpreadBot(){
        super();

        health = Math.random()+2;
        attack = (Math.random()/2)+0.5;
        speed = Math.random()+0.5;
        
        name = "K" + productionNumber;
    }
    public void attack(Simulation s){}
    
}
