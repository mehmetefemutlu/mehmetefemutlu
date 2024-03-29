public class DefenceBot extends Robot {

    public DefenceBot(){
        super();

        health = (Math.random()*3)+3;
        attack = (Math.random()/2)+0.5;
        speed = (Math.random()/2)+0.5;
        
        name = "D" + productionNumber;
    }
    public void attack(Simulation s){
        Robot r = s.getLowestSpeed(!isRedTeam);
        System.out.println(displayAttack(r));;
        
        if(r.getHitAndDestroyed(attack)){
            s.removeRobot(r);
        }
    }      
    
}
