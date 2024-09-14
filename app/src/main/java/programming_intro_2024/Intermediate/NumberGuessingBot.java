package programming_intro_2024.Intermediate;


/**
 * Your task is to modify the provided number guessing game so that the computer (bot) 
 * automatically guesses the correct number consistantly in below 8 attampts.
 */

import static java.lang.System.out;

import java.util.Random;

public class NumberGuessingBot {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int low = 1;
        int high = 100;

        out.println("Bot is playing the Number Guessing Game!");
        out.println("The secret number is: " + secretNumber);

        while (true) {
            // Write your code here to guess the number
            // You can use the variables low, high, but not attempts to keep track of the range and number of attempts
            // do not use the variable secretNumber, the following is just an example
            out.println("Bot found the number: " + secretNumber);
            break;
        }
    }
}