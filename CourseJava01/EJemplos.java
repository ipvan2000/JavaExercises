
    
import java.util.Scanner;
public class EJemplos{
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Question 1
        System.out.println("Question 1: What is the capital of France?");
        System.out.println("A) Berlin");
        System.out.println("B) London");
        System.out.println("C) Paris");
        System.out.println("D) Madrid");
        System.out.print("Your answer: ");
        char answer1 = Character.toUpperCase(scanner.next().charAt(0));
        if (answer1 == 'C') {
            score++;
        }

        // Question 2
        System.out.println("Question 2: What is the largest planet in our solar system?");
        // Options and input validation similar to Question 1

        // Question 3
        System.out.println("Question 3: Who painted the Mona Lisa?");
        // Options and input validation similar to Question 1

        // Question 4
        System.out.println("Question 4: What is the powerhouse of the cell?");
        // Options and input validation similar to Question 1

        // Question 5
        System.out.println("Question 5: What is the chemical symbol for water?");
        // Options and input validation similar to Question 1

        // Computing and displaying the final score
        double percentageScore = (score / 5.0) * 100;
        System.out.println("Your final score: " + percentageScore + "%");
    }
}


