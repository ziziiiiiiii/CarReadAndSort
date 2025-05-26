// This class is used by the CarOutputVin class in order to categorize
// data from a .txt file to be sorted and printed.

public class CarVin {
    String make;
    String model;
    String year;
    String vin;

    public CarVin(String make, String model, String year, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }
}