package programming_intro_2024.Beginner;

// This class is like a blueprint for a House
public class ClassAnalogy {

    // Attributes of the house (fields)
    private String color;
    private int numberOfRooms;

    // Constructor to initialize the house attributes
    public ClassAnalogy(String color, int numberOfRooms) {
        this.color = color;
        this.numberOfRooms = numberOfRooms;
    }

    // Method to get the color of the house
    public String getColor() {
        return color;
    }

    // Method to set the color of the house
    public void setColor(String color) {
        this.color = color;
    }

    // Method to get the number of rooms in the house
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    // Method to set the number of rooms in the house
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    // Method to display the details of the house
    public void displayHouseDetails() {
        System.out.println("House Color: " + color);
        System.out.println("Number of Rooms: " + numberOfRooms);
    }

    public static void main(String[] args) {
        // Creating an object of the ClassAnalogy class (like building a house from a blueprint)
        ClassAnalogy myHouse = new ClassAnalogy("Blue", 3);

        // Displaying the details of the house
        myHouse.displayHouseDetails();

        // Changing the color of the house
        myHouse.setColor("Red");

        // Displaying the updated details of the house
        System.out.println("Updated House Details:");
        myHouse.displayHouseDetails();
    }
}
