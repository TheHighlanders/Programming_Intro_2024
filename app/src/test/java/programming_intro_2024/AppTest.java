/*
 * This source file was generated by the Gradle 'init' task
 */
package programming_intro_2024;

import org.junit.jupiter.api.Test;

import programming_intro_2024.Beginner.App;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
