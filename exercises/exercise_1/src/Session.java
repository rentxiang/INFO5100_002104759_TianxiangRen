import java.util.*;
// import Exercise1.com.exer1
public class Session {
    List<Student> list = new ArrayList<>();//student list
    //default constructor
    // public Session(){

    // }
    //student add method
    public void addStudent(Student s){
        list.add(s);
        // Collections.sort(list);

    }
    public void addFullTime(FullTime f){
        list.add(f);
        // Collections.sort(list);
    }

    // //calculate average quiz score per student method
    // public void quizAver(Session se){
    //     int sum = 0;
    //     double aver = 0;
    //     int count = list.size();//default(preferred) session size is 20.
    //     for(Student s : list){
    //         sum += s.QuizzesScore;
    //         aver = sum / count;
    //     }
    //     System.out.println("-----------------------");
    //     System.out.println("The average quiz score is: " + aver);
    // }

    //print the list of quiz scores in ascending order for one session
    // public void printQuiz(Session se){
    //     System.out.println("-----------------------");
    //     System.out.println("The list of quiz score is:");
    //     // Collections.sort(list);

    //     for(Student s : list){
    //         System.out.println(list.indexOf(s)+ 1 + ".Name: " + s.Name + "  Score: " + s.QuizzesScore);
    //     }
    //     System.out.println("-----------------------");
    // }

    //method to print names of part-time students
    public void printPartime(Session se){
        System.out.println("-----------------------");
        System.out.println("The list of part-time student is:");

        for(Student s : list){
            if(s.StudentType == "PartTime"){
                System.out.println("Name: " + s.Name);
            }
        }
        System.out.println("-----------------------");
    }

    //public method to print exam scores of full-time students
    public void printFulltime(Session se){
        System.out.println("-----------------------");
        System.out.println("The list of exams scores of full-time student is:");

        for(Student s : list){
            if(s.StudentType == "FullTime"){
                System.out.println("Name: " + s.Name + " Exam1: " + ((FullTime)s).Exam1Score + " Exam2 " + ((FullTime)s).Exam2Score);
            }
        }
        System.out.println("-----------------------");
    }
}

