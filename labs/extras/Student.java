public class Student {

    // Instance variables
    private int ID;
    private String name;
    private String address;

    // Constructor
    public Student(int ID, String name, String address)
    {   
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    public Student(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
        this.address = ""; 
    }

    // Setter and Getter

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setID (int ID)
    {
        if(ID > 0)
        {
            this.ID = ID;
        }
    }

    public int getID()
    {
        return ID;
    }

    public String toString()
    {
        return ID + "," + name + "," + address;
    }

    
}
