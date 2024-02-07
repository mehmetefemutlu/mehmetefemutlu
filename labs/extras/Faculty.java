public class Faculty {

    private int ID;
    private String name;

    public Faculty(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    public String toString()
    {
        return ID + " - " + name;
    }
    
}
