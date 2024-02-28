/*
 * This class takes item objects and adds them to the inventory
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Item> items;
    
    //Constructor
    public Inventory(){
        items = new ArrayList<Item>();
    }
    
    //Takes inputs from the user
    Scanner in = new Scanner(System.in);

    //Fills the inventory with item objects
    public void fill_inventory(){
        do{
            String type = null;
        
            System.out.println("Type the number of the item you want to add to the inventory");
            System.out.println("1) Book, 2) Television, 3) Water, 4) Milk, 5) Exit");
            int n = in.nextInt();
            if(n==1){
                type = "Book";
            }
            else if(n==2){
                type = "Television";
            }
            else if(n==3){
                type = "Water";
            }
            else if(n==4){
                type = "Milk";
            } 
            else if(n==5){
                break;
            }
            else{
                System.out.println("Invalid choice");
                break;
            }
            System.out.println("Enter the weight, price, and count for the " + type + " Use a comma to separate each value.");
            in.nextLine();

            String str = in.nextLine();
            String [] values = str.split(",");
            
            int weight = Integer.parseInt(values[0]);
            int price = Integer.parseInt(values[1]);
            int count = Integer.parseInt(values[2]);
 
            items.add(new Item(type,weight,price,count));
        }
        while(true);
    }

    //Lists the inventory 
    public void list_inventory(){
        for(Item i:items){
            System.out.println(i);
        }
    }

    //Accessors
    public int getSize(){
        return getItems().size();
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public int getTotalPrice(){
        int total = 0;
        for(Item i:items){
            total += i.getPrice()*i.getCount();
        }
        return total;
    }
    public int getTotalWeight(){
        int total = 0;
        for(Item i:items){
            total += i.getWeight()*i.getCount();
        }
        return total;
    }

    public Item findPreciousItem(){
        Item i = items.get(0);
        for(int j=0; j<items.size()-1;j++){
            if(items.get(j).compareTo(items.get(j+1))<0){
                i = items.get(j+1);
            }
        }
        return i;
    }
 

 
}
