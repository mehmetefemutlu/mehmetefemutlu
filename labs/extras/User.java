/**
 * User
 */
import java.util.ArrayList;

public class User implements Comparable<User>{
    
    //Instance variables
    private int ID;
    private String name;
    private ArrayList<Book> borrowed;

    //Constructor
    public User(String name, int ID){
        this.name = name;
        this.ID = ID;
        borrowed = new ArrayList<Book>();
    }
    //Service method that checks if the user has the book
    public boolean IsBookHere(Book b){
        for(Book book:borrowed){
            if(book.compareTo(b)==1){
                return true;
            }
        }
        return false;
    }
    //Accessors
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public ArrayList<Book> getBorrowed(){
        return borrowed;
    }
    //Comparable interface method
    public int compareTo(User u){
        if(this.getID()==u.getID()){
            return 1;
        } 
        return 0;       
    }
    //Overriding
    public String toString(){
        return "User: " + getName() + "," + getID();
    } 
}
