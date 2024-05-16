public class PredatorBot extends Robot {

    public PredatorBot(){
        super();

        health = Math.random()+2;
        attack = Math.random()+2;
        speed = (Math.random()/2)+0.5;


        name = "P" + productionNumber;
    }
    public void attack(Simulation s){
        Robot r = s.getHighestHealth(!isRedTeam);
        System.out.println(displayAttack(r));;
        
        if(r.getHitAndDestroyed(attack)){
            s.removeRobot(r);
        }
    }
    
}
