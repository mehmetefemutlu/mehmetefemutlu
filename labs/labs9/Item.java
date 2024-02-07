/*
 * This class defines the item objects
 */
public class Item implements Comparable<Item>{

    //Static data members
    private static int noOfItems = 1;

    //Instance data members
    private int ID;
    private int weight;
    private int price;
    private int count;
    private String type;

    //Constructor
    public Item(String type, int weight, int price, int count){
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.count = count;
        ID = noOfItems++;     
    }

    //Accessors
    public int getWeight(){
        return weight;
    }
    public int getPrice(){
        return price;
    }
    public int getCount(){
        return count;
    }

    //Setters
    public void setCount(){
        this.count = this.count-1;
    }
    public void setCount(int n){
        this.count = n;
    }

    public int compareTo(Item o){
        return (this.price-o.price);
    }

    //Converts item object to string
    public String toString(){
        return "Item " + ID + ":" + "\n" + "Type: " + type + "\n" + "Count: " + count + "\n" + "Weight: " + weight + "\n" + "Price: " + price + "\n";
    }
    
}
