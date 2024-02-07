/*
 * This class creates a shipment 
 */
import java.util.ArrayList;

public class Fleet_revision {
    
    //Instance data members
    private final int WEIGHT_CAPACITY= 100;
    private final int COST= 100;
    private ArrayList<Vehicle> vehicles;

    //Constructor
    public Fleet_revision(){
        vehicles = new ArrayList<Vehicle>();
    }

    //Creates a fleet with creating necessary amount of vehicles
    public void create_shipment(Inventory inventory){

        Vehicle vehicle = new Vehicle(WEIGHT_CAPACITY,COST);
        
        //Checks if the inventory is empty
        while(inventory.getSize()!=0){

            //Checks the items in the inventory
            for(int i=0; i<inventory.getSize(); i++){
                Item item = inventory.getItems().get(i);

                //If item cannot fit it gives an error mesage
                if(item.getCount()*item.getWeight()>WEIGHT_CAPACITY){
                    System.out.println("Some items cannot be loaded to the vehicles");
                    break;
                }
                else{
                    //Adds item to the vehicle
                    if(item.getCount()*item.getWeight()<=(WEIGHT_CAPACITY-vehicle.getCurrentWeight())){
                        vehicle.setItems(item);
                        vehicle.setCurrentWeight(item);
                        inventory.getItems().remove(item);
                        i--;
                    }
                    else{
                        int temp = item.getCount();   

                        //Pieces apart the item to fit to the vehicle
                        for(int m=0; m<temp; m++){
                            item.setCount();
                            if(item.getCount()*item.getWeight()<=(WEIGHT_CAPACITY-vehicle.getCurrentWeight())){
                                vehicle.setItems(item);
                                vehicle.setCurrentWeight(item);
                                break;
                            }
                        }

                        //Rearranges the items count
                        item.setCount(temp-item.getCount());
                        vehicles.add(vehicle);

                        //Creates a new vehicle
                        vehicle = new Vehicle(WEIGHT_CAPACITY,COST);

                        //Adds the remaining item to the new vehicle
                        vehicle.setItems(item);
                        vehicle.setCurrentWeight(item);
                        inventory.getItems().remove(item);
                        i--;
                        vehicles.add(vehicle);
                    }
                }
            }
        } 
    }  

    //Lists the fleet
    public void list_fleet(){
        for(Vehicle v: vehicles){
            System.out.println(v);
        }
    }


 
}