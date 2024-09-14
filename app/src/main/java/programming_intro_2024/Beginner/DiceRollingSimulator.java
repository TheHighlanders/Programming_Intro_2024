package programming_intro_2024.Beginner;

import java.util.Random;

public class DiceRollingSimulator {
    // TODO: Declare a Random object as a class member

    public DiceRollingSimulator() {
        // TODO: Initialize the Random object
    }

    public int rollDie(int sides) {
        // TODO: Implement the die rolling logic
        // Hint: Use the Random object to generate a number between 1 and 'sides'
        return 0; // Replace this with your implementation
    }

    public static void main(String[] args) {
        // Hint You can use the following code to test your implementation:
        DiceRollingSimulator simulator = new DiceRollingSimulator();
        int rollResult = simulator.rollDie(6);
        System.out.println("Rolled a " + rollResult);
    }
}