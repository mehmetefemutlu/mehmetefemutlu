/**
 * Student
 */
public class Student {

    private String name;
    private String surname;
    private String schoolID;
    private int age;
    private Grade [] grades;

    public Student(String schoolID, String name, String surname, int age){
        this.schoolID = schoolID;
        this.age = age;
        this.name = name;
        this.surname = surname;
        grades = new Grade[0];
    }

    public String toString(){
        return schoolID + ", " + name + " " + surname + ", " + age;
    }

    private void setSize(){
        Grade [] newGrade = new Grade[grades.length+1];
        for(int i=0; i<grades.length; i++){
            newGrade[i] = grades[i];
        }
        grades = newGrade;
    }

    public void setGrades(String examName, float weight, float points) throws Exception{
        if(examName.length()<=3){
            throw new Exception(examName + " must be longer than 3 characters!");
        }

        setSize();

        for(int i=0; i<grades.length; i++){
            if(grades[i]!=null && examName.equals(grades[i].getExamName())){
                grades[i] = new Grade(examName, weight, points);
                break;
            }
        }
        grades[grades.length-1] = new Grade(examName, weight, points);   
           
    }
    
    public String getSchoolID(){
        return schoolID;
    }

    public String getName(){
        return name;
    }
    
    public Grade [] getGrades(){
        return grades;
    }

    public String getSurname(){
        return surname;
    }
}