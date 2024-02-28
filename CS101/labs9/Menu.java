import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        System.out.println("Welcome to the inventory management system!");
        
        //Defining variables
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);
        Inventory inventory = null;
        
        while (choice != 3){
            System.out.println("Please select an option:");
            System.out.println("1. Create a new inventory");
            System.out.println("2. Create a new shipment");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");


            choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating a new inventory");
                    inventory = new Inventory();
                    inventory.fill_inventory();
                    if(inventory.getItems().size()==0){
                        break;
                    }
                    System.out.println("Inventory created. Details: -----------------\n");
                    inventory.list_inventory();

                    System.out.println("Most precious item is: \n" +  inventory.findPreciousItem());
                                     
                    System.out.println("Total price: " + inventory.getTotalPrice());
                    System.out.println("Total weight: " + inventory.getTotalWeight());
                    System.out.println("---------------------------------------------");
                    break;
                case 2:
                    //Check if inventory exists
                    if (inventory == null){
                        System.out.println("Please create an inventory first");
                        break;
                    }
                    System.out.println("Creating a new shipment");

                    //Create a new fleet and create a shipment
                    Fleet fleet = new Fleet();
                    fleet.create_shipment(inventory);

                    //Display the fleet
                    System.out.println("Fleet created. Details: -----------------\n");
                    fleet.list_fleet();
                    System.out.println("---------------------------------------------");
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }   
        
    keyboard.close();
    }

}