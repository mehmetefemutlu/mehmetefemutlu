public class SimpleBot extends Robot{

    public SimpleBot(){
        super();

        health = Math.random()+2;
        attack = Math.random()+1;
        speed = Math.random()+1;

        name = "S" + productionNumber;
    }

    public void attack(Simulation s){
        

    }
    
}
