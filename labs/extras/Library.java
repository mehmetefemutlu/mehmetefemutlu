/**
 * Library
 */
import java.util.ArrayList;

public class Library {
    //Instance constants
    private final int MAX_USER_CAPACITY = 10;
    private final int MAX_BOOK_CAPACITY = 10;

    //Instance variables
    private String name;
    private ArrayList<Book> books;
    private ArrayList<User> users;
    
    //Constructor
    public Library(String name){
        this.name = name;
        books = new ArrayList<Book>();
        users = new ArrayList<User>();

    }
    //Mutator method that adds user
    public void addUser(User u){
        if(users.size()<MAX_USER_CAPACITY && !IsUserHere(u)){
            users.add(u);
            System.out.println(u + " added succesfully");
        }
        else{
            System.out.println("User cannot be added to the system");
        }
    }
    //Mutator method that removes user
    public void removeUser(User u){
        if(IsUserHere(u)){
            users.remove(u);
            System.out.println(u + " removed succesfully");
        }
        else{
            System.out.println("User is not in the system");
        }
    }
    //Mutator method that adds book
    public void addBook(Book b){
        if(books.size()<MAX_BOOK_CAPACITY && !IsBookHere(b)){
            for(int i=0; i<b.getQuantity(); i++){
                books.add(b);
            }
            System.out.println(b + " added succesfully");
        }
        else{
            System.out.println("Book cannot be added to the system");
        }
    }
    //Mutator method that removes user
    public void removeBook(Book b){
        if(IsBookHere(b)){
            books.remove(b);
            System.out.println(b + " removed succesfully");
        }
        else{
            System.out.println("Book is not in the inventory");
        }
    }
    //Mutator method that lends book to the user
    public void lendBook(User u, Book b){
        if(IsBookHere(b) && IsUserHere(u)){
            books.remove(b);
            u.getBorrowed().add(b);
            b.decrementQuantity();
            System.out.println(b  + " borrowed succesfully to the " + u);
        }
        else{
            System.out.println("Book could not borrowed");
        }
    }
    //Mutator method that takes the book back from the user
    public void returnBook(User u, Book b){
        if(u.IsBookHere(b) && IsUserHere(u)){
            books.add(b);
            u.getBorrowed().remove(b);
            b.incrementQuantity();
            System.out.println(b + " returned succesfully from the " + u);
        }
        else{
            System.out.println("User does not have this book");
        }
    }
    //Service method that checks if the user is in the system
    public boolean IsUserHere(User u){
        for(User user:users){
            if(user.compareTo(u)==1){
                return true;
            }
        }
        return false;
    }
    //Service method that checks if the book is in the inventory
    public boolean IsBookHere(Book b){
        for(Book book:books){
            if(book.compareTo(b)==1){
                return true;
            }
        }
        return false;
    }
    //Service method that finds the wanted user's position in the array list
    public int findUserPosition(User u){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).compareTo(u)==1){
                return i;
            }
        }
        return -1;
    }
    //Service method that finds the wanted book's position in the array list
    public int findBookPosition(Book b){
        for(int i=0; i<books.size(); i++){
            if(books.get(i).compareTo(b)==1){
                return i;
            }
        }
        return -1;
    }
    //Accessor method
    public String getName(){
        return name;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
}