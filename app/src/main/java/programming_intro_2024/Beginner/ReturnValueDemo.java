package programming_intro_2024.Beginner;

public class ReturnValueDemo {

    // Method that returns a string
    public String getGreeting() {
        return "Hello, World!";
    }

    // Method that returns the sum of two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method that returns true if the number is even, false otherwise
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        ReturnValueDemo demo = new ReturnValueDemo();

        // Call the getGreeting method and print the result
        String greeting = demo.getGreeting();
        System.out.println("Greeting: " + greeting);

        // Call the add method and print the result
        int sum = demo.add(5, 3);
        System.out.println("Sum: " + sum);

        // Call the isEven method and print the result
        boolean isEven = demo.isEven(4);
        System.out.println("Is 4 even? " + isEven);

        isEven = demo.isEven(5);
        System.out.println("Is 5 even? " + isEven);
    }
}
