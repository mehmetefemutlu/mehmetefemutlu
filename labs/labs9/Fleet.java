/*
 * This class creates a shipment 
 */
import java.util.ArrayList;

public class Fleet {
    
    //Instance data members
    private final int WEIGHT_CAPACITY= 100;
    private final int COST= 100;
    private ArrayList<Vehicle> vehicles;

    //Constructor
    public Fleet(){
        vehicles = new ArrayList<Vehicle>();
    }

    //Creates a fleet with creating necessary amount of vehicles
    public void create_shipment(Inventory inventory){
        
        while(inventory.getSize()!=0){

            Vehicle vehicle = new Vehicle(WEIGHT_CAPACITY,COST);

            //Checks the items in the inventory
            for(int i=0; i<inventory.getSize(); i++){
                Item item = inventory.getItems().get(i);
                
                //Checks if item fits into the vehicle
                if(item.getCount()*item.getWeight()>WEIGHT_CAPACITY){
                    System.out.println("Some items cannot be loaded to the vehicles");
                    return;
                }
                else{
                    //Adds item to the vehicle
                    if(item.getCount()*item.getWeight()<=(WEIGHT_CAPACITY-vehicle.getCurrentWeight())){
                        vehicle.setItems(item);
                        vehicle.setCurrentWeight(item);
                        inventory.getItems().remove(item);
                    }
                } 
              
            }
            vehicles.add(vehicle);
        }
        
    }

    
    //Lists the fleet
    public void list_fleet(){
        for(Vehicle v: vehicles){
            System.out.println(v);
        }
    }


 
}
