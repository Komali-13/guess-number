Guess number game 


import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Random random = new Random();
      int maxNumber = 100; // maximum number to be generated
      int numberOfAttempts = 5; // maximum number of attempts per round
      int round = 1; // current round number
      int score = 0; // current score
      
      System.out.println("Welcome to Guess the Number game!");
      System.out.println("You have " + numberOfAttempts + " attempts per round.");
      
      // main game loop
      while (true) {
         int secretNumber = random.nextInt(maxNumber) + 1;
         System.out.println("\nRound " + round + ": Guess the secret number between 1 and " + maxNumber + ".");
         int attempt = 1;
         
         // round loop
         while (attempt <= numberOfAttempts) {
            System.out.print("Attempt #" + attempt + ": ");
            int guess = input.nextInt();
            
            if (guess == secretNumber) {
               System.out.println("Congratulations! You guessed the secret number in " + attempt + " attempt(s).");
               
               // calculate points and display score
               int points = numberOfAttempts - attempt + 1;
               score += points;
               System.out.println("You scored " + points + " point(s) in this round. Your total score is " + score + ".");
               
               // ask for another round
               System.out.print("\nDo you want to play another round? (yes/no) ");
               String answer = input.next().toLowerCase();
               if (answer.equals("yes")) {
                  round++;
                  break;
               } else {
                  System.out.println("Thank you for playing! Your final score is " + score + ".");
                  return;
               }
            } else if (guess < secretNumber) {
               System.out.println("The secret number is higher than " + guess + ".");
            } else {
               System.out.println("The secret number is lower than " + guess + ".");
            }
            
            attempt++;
         }
         
         // out of attempts
         System.out.println("Sorry, you have run out of attempts. The secret number was " + secretNumber + ".");
         
         // ask for another round
         System.out.print("\nDo you want to play another round? (yes/no) ");
         String answer = input.next().toLowerCase();
         if (answer.equals("yes")) {
            round++;
         } else {
            System.out.println("Thank you for playing! Your final score is " + score + ".");
            return;
         }
      }
   }
}
