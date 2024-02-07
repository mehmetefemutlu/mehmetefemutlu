import java.util.ArrayList;

public class Course {

    private String name;
    private int sectionCount;
    private ArrayList<Section> sections;

    public Course(String name)
    {
        this.name = name;
        this.sectionCount = 0;
        sections = new ArrayList<Section>();
    }

    public void addSection(Section sec)
    {
        sections.add(sec);
        sectionCount++;
    }

    public boolean removeSection(Section s)
    {
        boolean result = sections.remove(s);
        if(result)
        {
            sectionCount--;
        }
        return result;
    }

    public String toString()
    {
        String result = "";
        result += name + "\n ************ \n"  ;
        for(Section s: sections)
        {
            result += s + " \n ********* \n";
        }
        return result;
    }
    
}
