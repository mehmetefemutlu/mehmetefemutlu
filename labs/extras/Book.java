/**
 * Book
 */
public class Book implements Comparable<Book>{

    //Instance variables
    private String title;
    private String author;
    private int quantity;
    private int ISBN;

    //Constructor
    public Book(String title, String author, int quantity, int ISBN){
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.ISBN = ISBN;
    }
    //Accessors
    public String getTitle(){
        return title;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getAuthor(){
        return author;
    }
    public int getISBN(){
        return ISBN;
    }
    //Mutators
    public void decrementQuantity(){
        quantity--;
    }
    public void incrementQuantity(){
        quantity++;
    }
    //Comparable interface method
    public int compareTo(Book b){
        if(this.getISBN() == b.getISBN()){
            return 1;
        }
        return 0;
    }
    //Overriding
    public String toString(){
        return "Book: " + getTitle() + "," + getAuthor() + "," + getISBN() + "," + getQuantity(); 
    }
}