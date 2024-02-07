import java.util.ArrayList;

public class Section {

    private int number;
    private ArrayList<Student> students;
    private Faculty faculty;

    public Section(int number, Faculty f)
    {
        this.number = number;
        students = new ArrayList<Student>();
        faculty = f;
    }

    public Section(int number, Faculty f, ArrayList<Student> students)
    {
        this.number = number;
        this.students = students;
        faculty = f;
    }


    public void addStudent(Student s)
    {
        students.add(s);
    }

    public String toString()
    {
        String result = "";
        result += "Section " + this.number + "\n";
        result += "Faculty " + this.faculty + "\n";
        result += "Students \n";
        result += "-------- \n";
        for(Student s: students)
        {
            result += s + "\n";
        }  
        return result;
    }
    
}
