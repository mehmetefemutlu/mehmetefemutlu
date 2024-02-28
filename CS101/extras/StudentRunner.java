import java.util.ArrayList;

public class StudentRunner {

    public static void main(String[] args)
    {

        Faculty f = new Faculty(100, "Ozcan Rocks!");
        Faculty f2 = new Faculty(200, "Ugur Dogrusoz");

        Student ali = new Student(123, "Ali", "Ankara");
        Student veli = new Student(12, "Veli", "Istanbul");
        Student will = new Student(1, "Will", "Washington");
        Student parakash = new Student(2, "Parakash", "New Delhi");

        //Section sec3 = new Section(3, f);
        //sec3.addStudent(ali);
        //sec3.addStudent(veli);
        ArrayList<Student> sec3students = new ArrayList<Student>();
        sec3students.add(ali);
        sec3students.add(veli);

        Section sec3 = new Section(3, f, sec3students);

        Section sec1 = new Section(1, f2);
        Section sec2 = new Section(2, f2);

        sec1.addStudent(will);
        sec2.addStudent(parakash);

        Course cs101 = new Course("The Most Important Course - CS101");
        cs101.addSection(sec2);
        cs101.addSection(sec3);
        cs101.addSection(sec1);
        System.out.println(cs101);
    }    
}
