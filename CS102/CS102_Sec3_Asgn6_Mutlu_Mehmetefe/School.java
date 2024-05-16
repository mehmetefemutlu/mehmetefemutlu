import java.io.File;
import java.util.Scanner;

/**
 * School
 */
public class School {
    
    private Student [] students;
    private int tracker;
    private int count;

    public School(){
        students = new Student[10];
        tracker = 0;
        count = 0;
    }

    public void addStudent(String schoolID, String name, String surname, int age) throws Exception{
        count = 0;
        for(int i=0; i<students.length; i++){
            if(students[i]!=null){
                count++;
            }
        }    
        
        for(int i=0; i<count; i++){
            if(schoolID.equals(students[i].getSchoolID())){
                throw new Exception("Duplicate ID: " + schoolID);
            }
        }
    
        tracker++;
        if(tracker>=(students.length/2)){
            Student [] newStudents = new Student[students.length*2];
            for(int i=0; i<count; i++){
                newStudents[i] = students[i];
            }
            students = newStudents;
        }
        Student student = new Student(schoolID, name, surname, age);

        if(count<1){
            students[count] = student;
        }
        else{
            addToCorrectPlace(student, count);
        }
    }

    public Student getStudent(String schoolID) throws Exception{
        return searchStudent(0, count, schoolID);
    }

    public void printStudents(){
        for(Student s:students){
            if(s!=null)
            System.out.println(s);
        }
    }

    public Student [] getStudentsByNameOrder(){
        Student [] arr = students;
        quickSort(arr, 0, count);
        return arr;
    }

    public void printStudentsByNameOrder(){
        for(Student s: getStudentsByNameOrder()){
            if(s!=null)
            System.out.println(s);
        }
    }

    public float getGradeAverage(Student s){
        Grade [] sGrades = s.getGrades();
        float totalSum =0;
        float totalWeight =0;

        for(Grade g:sGrades){
            totalSum += g.getPoints()*g.getWeight();
            totalWeight += g.getWeight();
        }

        if(totalWeight==0){
            return 0;
        }
        return totalSum/totalWeight;
    }

    public void printStudentGradeAverages(){
        Student [] arr = students;
        bubbleSort(arr, count);
        for(Student s:arr){
            if(s!=null && getGradeAverage(s)!=0)
            System.out.print(s + " - Average: " + getGradeAverage(s) + "\n");
        }
    }

    public void printGradesOf(String ID){
        try{
            Student s = getStudent(ID);
            System.out.println(s);
            for(Grade gr: s.getGrades()){
                System.out.print(gr);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void processTextFile(String fileName){
        try (Scanner in = new Scanner(new File(fileName))) {
            String str = in.nextLine();
            while(str!= null){
                str.trim();
                if(str.startsWith("Student:")){
                    String [] parts = str.split(":")[1].trim().split(",");
                    String [] nameParts = parts[0].split(" ");
                    String name = nameParts[0].trim();
                    String surname = nameParts[1].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    String ID = parts[2].trim();
                    try{
                        addStudent(ID, name, surname, age);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                }
                else if(str.startsWith("Grade:")){
                    String [] parts = str.split(":")[1].trim().split(",");
                    String ID = parts[0].trim();
                    String examName = parts[1].trim();
                    Float weight = Float.parseFloat(parts[2].trim());
                    Float points = Float.parseFloat(parts[3].trim());
                    try{
                        Student s = getStudent(ID);
                        s.setGrades(examName, weight, points);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                }
                else if(str.equals("PrintStudents")){
                    printStudents();
                    System.out.println();
                }
                else if(str.startsWith("GradesOf")){
                    String ID = str.split(":")[1].trim();
                    printGradesOf(ID);
                    System.out.println();
                }
                else if(str.equals("PrintByGradeAverages")){
                    printStudentGradeAverages();
                    System.out.println();
                }
                else if(str.equals("PrintByNameOrder")){
                    printStudentsByNameOrder();
                    System.out.println();
                }
                str = in.nextLine();
            }

            in.close();
        } 
        catch (Exception e) {
            System.out.println("Exiting");
            System.exit(0);
        }
    }

    private void bubbleSort(Student [] s, int count){
        boolean swapped = true;

        while(swapped){
            swapped = false;
            for(int i=0; i<count; i++){
                if(getGradeAverage(s[i])<getGradeAverage(s[i+1])){
                    swap(s, i, i+1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(Student [] s, int index1, int index2){
        Student temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }

    private void quickSort(Student [] arr, int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private int partition(Student [] arr, int low, int high){
        Student pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++){
            if((arr[j].getName().compareTo(pivot.getName())<0) || (arr[j].getName().compareTo(pivot.getName())==0 && arr[j].getSurname().compareTo(pivot.getSurname())<=0)){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private Student searchStudent(int low, int high, String ID) throws Exception{

        int start = low;
        int end = high;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(Long.valueOf(students[mid].getSchoolID()).compareTo(Long.valueOf(ID))<0){
                start = mid+1;
            }
            else if(Long.valueOf(students[mid].getSchoolID()).compareTo(Long.valueOf(ID))>0){
                end = mid-1;
            }
            else{
                return students[mid];
            }
        }
        throw new Exception("No such student with the ID: " + ID);
    }

    private void addToCorrectPlace(Student s, int count){
        for(int i=0; i<count; i++){
            if(Long.valueOf(s.getSchoolID())<=Long.valueOf(students[i].getSchoolID())){
                for(int j=count; j>=i; j--){
                    students[j+1] = students[j];
                }
                students[i] = s;
                break;
            }
        }
    }
}
