import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
  public static void main(String[] args) {
    String subject1 = "David loves to play Call of Duty";
    String subject2 = "Email me at rentxiang@gmail.com or rentxiang@github.com (fake)";
    String subject3 = "123-456-7890";
    String subject4 = "Password123";
    String subject5 = "12/31/2022";

    // Pattern 1: Find all words that start with the letter 't'
    Pattern pattern1 = Pattern.compile("\\bt\\w*\\b");
    Matcher matcher1 = pattern1.matcher(subject1);
    System.out.println("Pattern 1: Words that start with 't'");
    while (matcher1.find()) {
      System.out.println(matcher1.group());
    }
    System.out.println();

    // Pattern 2: Find all email addresses in a string
    Pattern pattern2 = Pattern.compile("\\b\\w+\\w+@\\w+\\.\\w+\\b");
    Matcher matcher2 = pattern2.matcher(subject2);
    System.out.println("Pattern 2: Email addresses");
    while (matcher2.find()) {
      System.out.println(matcher2.group());
    }
    System.out.println();

    // Pattern 3: Find all phone numbers in a string
    Pattern pattern3 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
    Matcher matcher3 = pattern3.matcher(subject3);
    System.out.println("Pattern 3: Phone numbers");
    while (matcher3.find()) {
      System.out.println(matcher3.group());
    }
    System.out.println();

    // Pattern 4: Find all strong passwords that contain uppercase letters, lowercase letters, and digits
    Pattern pattern4 = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}");
    Matcher matcher4 = pattern4.matcher(subject4);
    System.out.println("Pattern 4: Strong passwords");
    while (matcher4.find()) {
      System.out.println(matcher4.group());
    }
    System.out.println();

    // Pattern 5: Find all dates in mm/dd/yyyy format
    Pattern pattern5 = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
    Matcher matcher5 = pattern5.matcher(subject5);
    System.out.println("Pattern 5: Dates in mm/dd/yyyy format");
    while (matcher5.find()) {
      System.out.println(matcher5.group());
    }
    System.out.println();
    
    // Negative case
    String subject6 = "Dylan is dumb boy.";
    Pattern pattern6 = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
    Matcher matcher6 = pattern6.matcher(subject6);
    System.out.println("Negative case: Dates in mm/dd/yyyy format not found in subject6");
    if (!matcher6.find()) {
      System.out.println("No dates found in subject6.");
    }
  }
}
