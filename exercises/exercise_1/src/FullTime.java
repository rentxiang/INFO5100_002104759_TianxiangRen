public class FullTime extends Student {
    int Exam1Score;
    int Exam2Score;
    public FullTime(String Name, String StudentType, int Exam1Score, int Exam2Score){
        super(Name, StudentType);
        this.Exam1Score = Exam1Score;
        this.Exam2Score = Exam2Score;
    }
}