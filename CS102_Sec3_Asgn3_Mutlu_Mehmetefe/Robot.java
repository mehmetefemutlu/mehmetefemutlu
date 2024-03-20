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

    public boolean getHitAndDestroyed(double damage){
        double tempHealth = health;
        health = health - damage;
        return (tempHealth-damage)<=0;
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
        return name + " Health: " + String.format("%.3f",health)  + " Attack: " + String.format("%.3f",attack) + " Speed " + String.format("%.3f",speed);
    }
    public String displayAttack(Robot r){
        String str = r.name + " receives " + String.format("%.3f", attack) + " damage ->  remaining health: ";
        String str2 = this.name + " attacks " + r.name + "\n";
        if(this instanceof SpreadBot){
            str += "";
        }
        else{
            str = str2 + str;
        }
        if(r.health-attack<=0){
            str += String.format("%.3f", 0.0);
        }
        else{
            str += String.format("%.3f", (r.health-attack));
        }
        return str;
    }

    public abstract void attack(Simulation s);


}