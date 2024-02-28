public class Car 
{
    private int fuel;
    private int efficiency;

    public Car(int efficiency){
        fuel = 0;
        this.efficiency = efficiency;
    }

    public void drive(int miles){
        if(fuel>0)
        fuel -= (miles/efficiency);
    }
    public int getGasLevel(){
        return fuel;
    }
    public void addGas(int gas){
        this.fuel = this.fuel + gas;
    }
    public static void main(String[] args) 
    {
        Car myHybrid = new Car(50);
        myHybrid.addGas(20);
        myHybrid.drive(100);
        System.out.println(myHybrid.getGasLevel());
        
    }
}
