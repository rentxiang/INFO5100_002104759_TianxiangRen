import java.util.Arrays;

public class Main1{
    public static void main(String[] args) {

        //Create an instance of Session, populate it with 20 students and dummy scores
        Session ses = new Session();
        //adding 20 students, Full-time student will use FullTime constructor
        ses.addStudent(new FullTime("Drake", "FullTime",  80 , 70));
        ses.addStudent(new Student("Chris", "PartTime"));
        ses.addStudent(new FullTime("Wit", "FullTime",  80, 78));
        ses.addStudent(new Student("Lee", "PartTime"));
        ses.addStudent(new FullTime("MJ", "FullTime",  60 , 70));

        ses.addStudent(new FullTime("Mike", "FullTime", 23, 24));
        ses.addStudent(new FullTime("Jimmy", "FullTime", 0, 2));
        ses.addStudent(new FullTime("Scott", "FullTime", 98, 89));
        ses.addStudent(new Student("Mu", "PartTime"));
        ses.addStudent(new FullTime("Raja", "FullTime", 78, 90));

        ses.addStudent(new FullTime("Flex", "FullTime", 90, 88));
        ses.addStudent(new Student("Joe", "PartTime"));
        ses.addStudent(new FullTime("Cow", "FullTime", 85, 87));
        ses.addStudent(new Student("Dude", "PartTime"));
        ses.addStudent(new FullTime("Irelia", "FullTime", 60, 70));

        ses.addStudent(new FullTime("Ana", "FullTime", 50, 60));
        ses.addStudent(new FullTime("Alex", "FullTime", 78, 80));
        ses.addStudent(new Student("Creek", "PartTime"));
        ses.addStudent(new FullTime("Griffin", "FullTime", 79, 40));
        ses.addStudent(new FullTime("Jason", "FullTime",88, 76));

        
        // Call all public methods of Session and capture the output of those methods on console

        // Initializing student...
        System.out.println("-----------------------");
        System.out.println("Initializing student...");
        System.out.println("-----------------------");

        for(Student s: ses.list){
            s.setQuizzesScore();
            
            System.out.println(ses.list.indexOf(s)+ 1 + ".Name: " + s.Name + " Quiz Score: " + Arrays.toString(s.QuizzesScore));
        
        }
        // Average quiz score
        // Generate quiz scores for all students
        System.out.println("-----------------------");
        System.out.println("The average quiz score for each student is: ");
        
        for(Student s: ses.list){

            //calculate and print them:
            System.out.println(ses.list.indexOf(s)+ 1 + ".Name: " + s.Name + " Average Score: " + s.getAverQuizzesScore());
        
        }
        // // Print score list
        System.out.println("-----------------------");
        System.out.println("The sorted quiz score for each student is: ");
        for(Student s: ses.list){
            
            //sort and print them in ascending
            // s.getAscQuiz(s);

            System.out.println(ses.list.indexOf(s)+ 1 + ".Name: " + s.Name + "  Score: " + Arrays.toString(s.getAscQuiz(s)));

        }
        // ses.printQuiz(ses);
        //part-time student names
        ses.printPartime(ses);
        //full-time student exams scores
        ses.printFulltime(ses);
    }
}
