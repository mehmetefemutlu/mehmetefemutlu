public class SpeedBot extends Robot {

    public SpeedBot(){
        super();

        health = Math.random()+1;
        attack = Math.random()+1;
        speed = Math.random()+3;
        
        name = "X" + productionNumber;
    }

    public void attack(Simulation s){}
    
}
