package programming_intro_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programming_intro_2024.Beginner.DiceRollingSimulator;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class DiceRollingSimulatorTest {

    private DiceRollingSimulator simulator;

    @BeforeEach
    void setUp() {
        simulator = new DiceRollingSimulator();
    }

    @RepeatedTest(100)
    void testRollDieReturnsValueWithinRange() {
        int sides = 6;
        int result = simulator.rollDie(sides);
        assertTrue(result >= 1 && result <= sides, 
            "Die roll should be between 1 and " + sides + ", but was: " + result);
    }

    @Test
    void testRollDieWithOneSide() {
        int sides = 1;
        int result = simulator.rollDie(sides);
        assertEquals(1, result, "A one-sided die should always return 1");
    }

    @RepeatedTest(100)
    void testRollDieWithLargeSides() {
        int sides = 100;
        int result = simulator.rollDie(sides);
        assertTrue(result >= 1 && result <= sides, 
            "Die roll should be between 1 and " + sides + ", but was: " + result);
    }
}
