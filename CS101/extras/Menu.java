import java.util.Scanner;

/**
 * Menu(Runner)
 */
public class Menu {
    public static void main(String[] args) {

        Library library = new Library("Millet Kutuphanesi");

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to library management system of: " + library.getName());

        User user1 = new User("Ali", 1);
        User user2 = new User("Veli", 2);

        Book book1 = new Book("Numenor's Fall", "J.R.R Tolkien", 2, 245);
        Book book2 = new Book("Gondolin's Fall", "J.R.R Tolkien", 1, 278);

        library.addUser(user1);
        System.out.println(library.IsUserHere(user1));
        System.out.println(library.IsUserHere(user2));
        library.addUser(user2);

        library.addBook(book1);
        System.out.println(library.IsBookHere(book1));
        System.out.println(library.IsBookHere(book2));
        library.addBook(book2);

        library.lendBook(user2,book1);
        System.out.println(user2.IsBookHere(book1));
        System.out.println(user1.IsBookHere(book2));
        library.lendBook(user1,book1);
        System.out.println(book2);

        library.removeBook(book1);
        library.returnBook(user2, book2);
        library.returnBook(user1, book1);
        library.removeBook(book1);

        library.removeUser(user2);
        library.removeUser(user2);

        System.out.println(library.findUserPosition(user1));


        boolean done = false;
        do{
            System.out.println("Please select an option: ");
            
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Adding user");
                    library.addUser(new User("Ali",2));
                    break;
                case 2:
                    System.out.println("Adding book");
                    library.addBook(new Book("Benim Hüzünlü Orospularim", "Mehmet Efe", 10, 3169));
                    break;
                case 3:
                    System.out.println("Lending book");
                    library.lendBook(user2, book2);
                    break;
                case 4:
                    System.out.println("Returning book");
                    library.returnBook(user2, book2);
                    break;
                case 5:
                    System.out.println("Exiting");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while(!done);

        sc.close();


    }   
}
