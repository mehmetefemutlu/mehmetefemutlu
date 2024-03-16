public abstract class Robot implements Comparable<Robot>{

    protected double health;
    protected double attack;
    protected double speed;
    protected String name;
    protected boolean isRedTeam;

    protected static int productionNumber = -1;

    public Robot(){
        isRedTeam = false;
        productionNumber++;
    }

    public final boolean getHitAndDestroyed(double damage){
        return (health-damage)>0;
    }
    public final int compareTo(Robot r){
        if(this.speed < r.speed){
            return 1;
        }
        else if(this.speed > r.speed){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        String str = name + " Health: " + String.format("%.3f",health)  + " Attack: " + String.format("%.3f",attack) + " Speed " + String.format("%.3f",speed);
        return str;
    }

    public abstract void attack(Simulation s);



}