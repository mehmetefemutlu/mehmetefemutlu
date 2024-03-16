public class OneBot extends Robot {

    public OneBot(){
        super();

        health = (Math.random()/2)+0.5;
        attack = Math.random()+4;
        speed = (Math.random()/2)+0.5;
        
        name = "O" + productionNumber;
    }
    public void attack(Simulation s){}
    
}
