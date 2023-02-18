import java.util.*;
// import exercise1.com.java.*;

public class Student {
    String Name;
    String StudentType;
    int[] QuizzesScore;
    //constructor
    public Student(String Name, String StudentType){
        this.Name = Name;
        this.StudentType = StudentType;
        this.QuizzesScore = new int[15];
    }

    // @Override
    // public int compareTo(Student s){
    //     return this.QuizzesScore - s.QuizzesScore;
    // }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStudentType() {
        return StudentType;
    }

    public void setStudentType(String studentType) {
        StudentType = studentType;
    }

    public int getAverQuizzesScore() {
        int sum =0;
        for(int a:QuizzesScore){
            sum += a;
        }
        return sum/15;
    }

    public void setQuizzesScore() {
        Random rand = new Random();
        for (int i = 0; i < QuizzesScore.length; i++) {
            QuizzesScore[i] = rand.nextInt(100); // Generates a random integer between 0 and 99 (inclusive)
        }       
    }
    
    public int[] getAscQuiz(Student s){

        Arrays.sort(s.QuizzesScore);
        return s.QuizzesScore;
    }
}
