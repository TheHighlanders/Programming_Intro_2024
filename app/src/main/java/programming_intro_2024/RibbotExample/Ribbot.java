package programming_intro_2024.RibbotExample;

public class Ribbot {
    // Instance variables
    private String name;
    private int age;

    // Create a constructor with parameters for name and age (String and int)

    // Initialize the instance variables (give them values)

    // Getter for name (Create a function that returns the name)
    public Ribbot(String ribbotName, int ribbotAge){
        name = ribbotName;
        age = ribbotAge;
    }

    // Setter for name (Create a function that changes the name to a passed in parameter)

    // Getter for age (return the age)
    public int getRibbotAge(){
        return age;
    }

    // Setter for age (change the age to a passed in parameter)
    public int setRibbotAge(int ribbotAge){
        age = ribbotAge;
        return age;
    }

    // Method to make the ribbot Commit A Crime
    public void commitCrime() {
        // Confess to a crime
        System.out.println();
    }
}
