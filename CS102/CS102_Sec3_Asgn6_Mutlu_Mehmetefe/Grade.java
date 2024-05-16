/**
 * Grade
 */
public class Grade {
    
    private String examName;
    private float weight;
    private float points;

    public Grade(String examName, float weight, float points){
        this.examName = examName;
        this.points = points;
        this.weight = weight;
    }

    public String getExamName(){
        return examName;
    }

    public float getWeight(){
        return weight;
    }

    public float getPoints(){
        return points;
    }

    public String toString(){
        return "Exam Name: " + examName + " (Weight: " + weight + ") " + points + "\n";
    }
}
