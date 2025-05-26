// This class is used by both the CarOutput and CarOutputMaker
// classes in order to categorize data from a .txt file to be
// sorted and printed.

public class Car {
    String make;
    String model;
    String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}