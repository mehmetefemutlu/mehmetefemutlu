/*
 * This class defines the vehicle objects
 */
import java.util.ArrayList;

public class Vehicle {

    //Static data members
    private static int noOfVehicles = 1;

    //Instance data members
    private int ID;
    private int weightCapacity;
    private int cost;
    private int currentWeight;
    private ArrayList<Item> items;

    //Constructor
    public Vehicle(int weightCapacity, int cost){
        ID = noOfVehicles++;
        this.weightCapacity = weightCapacity;
        this.cost = cost;
        items = new ArrayList<Item>();
        currentWeight = 0;
    }

    //Accessors
    public int getCurrentWeight(){
        return currentWeight;
    }
    public ArrayList<Item> getItems(){
        return items;
    }

    //Setters
    public void setCurrentWeight(Item i){
        currentWeight += i.getCount()*i.getWeight();
    }
    public void setItems(Item i){
        items.add(i);
    }

    //Converts vehicle object to string
    public String toString(){  
        String str = "Vehicle: " + ID + "\n" + "Remaining Capacity: " + (weightCapacity-currentWeight) + "\n" + "Shipping cost: " + cost + "\n" + "Current Weight: " + currentWeight + "\n\n" + "Items: \n";
        for(Item i:items){
            str += i + "\n";
        }
        return str;
    }
}

