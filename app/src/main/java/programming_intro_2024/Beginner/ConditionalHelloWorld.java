package programming_intro_2024.Beginner;

public class ConditionalHelloWorld {
    public static void main(String[] args) {
        int condition = 1;

        if (condition == 1) {
            System.out.println("Hello, World! from if");
        } else if (condition == 2) {
            System.out.println("Hello, World! from else if");
        } else {
            System.out.println("Hello, World! from else");
        }

        

        for (int i = 0; i < 1; i++) {
            System.out.println("Hello, World! from for loop");
        }

        while (condition == 1) {
            System.out.println("Hello, World! from while loop");
            break;
        }

        // Dont worry about these for now

        // switch (condition) {
        //     case 1:
        //         System.out.println("Hello, World! from switch case 1");
        //         break;
        //     case 2:
        //         System.out.println("Hello, World! from switch case 2");
        //         break;
        //     default:
        //         System.out.println("Hello, World! from switch default");
        //         break;
        // }

        // do {
        //     System.out.println("Hello, World! from do-while loop");
        // } while (condition == 2);
    }
}
