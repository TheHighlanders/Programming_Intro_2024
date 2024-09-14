package programming_intro_2024;

import org.junit.jupiter.api.Test;

import programming_intro_2024.Intermediate.NumberGuessingBot;

import org.junit.jupiter.api.BeforeEach;
import org.checkerframework.checker.regex.qual.Regex;
import org.junit.jupiter.api.AfterEach;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.lang.System.console;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.annotation.RegEx;

class NumberGuessingBotTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        NumberGuessingBot.main(new String[0]);
    }

    @Test
    void testBotGeneratesValidSecretNumber() {
        String secretNumberLine = outContent.toString()
                .lines()
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new AssertionError("Expected at least two lines of output"));

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(secretNumberLine);

        assertTrue(matcher.find(), "No number found in the string: " + secretNumberLine);

        int secretNumber = Integer.parseInt(matcher.group());

        assertTrue(secretNumber >= 1 && secretNumber <= 100,
                "Secret number should be between 1 and 100, but was: " + secretNumber);
    }

    @Test
    void testBotPrintsFoundNumber() {
        String output = outContent.toString().trim();
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        Pattern pattern = Pattern.compile("Bot found the number: (\\d+)");
        Matcher matcher = pattern.matcher(lastLine);

        assertTrue(matcher.matches(), "Last line should be 'Bot found the number: X', but was: " + lastLine);

        int foundNumber = Integer.parseInt(matcher.group(1));
        assertTrue(foundNumber >= 1 && foundNumber <= 100,
                "Found number should be between 1 and 100, but was: " + foundNumber);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
}
