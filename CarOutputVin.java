// This program reads car makes, years, models, and VINs from a large .txt
// file, places them into an array list of type Car, and sorts them using
// quicksort. The program utilizes input from the user to print only
// cars of a specific make.

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class CarOutputVin{
    public static int partition(ArrayList<CarVin> data, int start, int end) {
        int mid = (start + end) / 2;
        CarVin pivotValue = data.get(mid);
        Collections.swap(data, start, mid);
        int endOfList = start;

        for (int index = start + 1; index <= end; index++) {
            if (compare(data.get(start), data.get(index))) {
                endOfList++;
                Collections.swap(data, index, endOfList);
            }
        }

        Collections.swap(data, start, endOfList);
        return endOfList;
    }

    public static void quickSort(ArrayList<CarVin> data, int start, int end) {
        if (start < end) {
            int result = partition(data, start, end);
            quickSort(data, start, result - 1);
            quickSort(data, result + 1, end);
        }
    }

    public static void quickSort(ArrayList<CarVin> data) {
        quickSort(data, 0, data.size() - 1);
    }

    public static boolean compare(CarVin compare1, CarVin compare2) {
        if (compare1.make.compareToIgnoreCase(compare2.make) > 0) {
            return true;
        }
        else if (compare1.make.compareToIgnoreCase(compare2.make) < 0) {
            return false;
        }
        else {
            if (compare1.year.compareToIgnoreCase(compare2.year) > 0) {
                return true;
            }
            else if (compare1.year.compareToIgnoreCase(compare2.year) < 0) {
                return false;
            }
            else {
                if (compare1.vin.compareToIgnoreCase(compare2.vin) > 0) {
                    return true;
                }
                else if (compare1.vin.compareToIgnoreCase(compare2.vin) < 0) {
                    return false;
                }
                else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter filename");
        String userInput = keyboard.nextLine();

        int loopVar = 0;
        ArrayList<CarVin> carList = new ArrayList<>();

        File file = new File(userInput);
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            if (loopVar == 0) {
                inputFile.nextLine();
                loopVar++;
                continue;
            }
            else {
                String fileInput = inputFile.nextLine();
                String[] splitInput = fileInput.split(",");
                carList.add(new CarVin(splitInput[0], splitInput[1], splitInput[2], splitInput[3]));
                loopVar++;
            }
        }

        quickSort(carList);
        int printLoopCounter = 0;
        int totalPrinted = 0;

        System.out.println("Oldest cars by make");

        for (CarVin printVar : carList) {
            if (printLoopCounter == 0 || !(carList.get(printLoopCounter - 1).make.equals(printVar.make))) {
                    System.out.printf("%15s%25s%5s%18s\n", printVar.make, printVar.model, printVar.year, printVar.vin);
                    totalPrinted++;
            }
            printLoopCounter++;

        }

        System.out.println(totalPrinted + " result(s)");

        inputFile.close();

    }
}