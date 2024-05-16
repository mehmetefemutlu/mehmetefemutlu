public class SimpleBot extends Robot{

    public SimpleBot(){
        super();

        health = Math.random()+2;
        attack = Math.random()+1;
        speed = Math.random()+1;

        name = "S" + productionNumber;
    }
    public void attack(Simulation s){
        Robot r = s.getRandomTarget(!isRedTeam);
        System.out.println(displayAttack(r));;

        if(r.getHitAndDestroyed(attack)){
            s.removeRobot(r);
        }
    }
    
}
