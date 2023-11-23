package Algorithms.demos;

import Algorithms.*;
import Lists.ArrayUnorderedList;
import Lists.UnorderedList;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        /* Array Based Testing */
        Car[] car = new Car[5];

        car[0] = new Car("Ford", "Fiesta", 2018, 15000);
        car[1] = new Car("BMW", "M3", 2018, 20000);
        car[2] = new Car("Mercedes", "C300", 2018, 25000);
        car[3] = new Car("Hyundai", "Elantra", 2018, 30000);
        car[4] = new Car("Jaguar", "F-Type", 2018, 35000);

        SortingAndSearchingArray.bubbleSort(car);

        for(Car c : car) {
            System.out.println(c);
        }

        // Binary search
        int targetPrice = 30000;
        boolean found = SortingAndSearchingArray.binarySearch(car, 0, car.length - 1, new Car("", "", 0, targetPrice));

        if(found) {
            System.out.println("Found a car with price " + targetPrice);
        } else {
            System.out.println("Did not find a car with price " + targetPrice);
        }


        // Linear search


        targetPrice = 15000;
        found = SortingAndSearchingArray.linearSearch(car, 0, car.length - 1, new Car("", "", 0, targetPrice));

        if(found) {
            System.out.println("Found a car with price " + targetPrice);
        } else {
            System.out.println("Did not find a car with price " + targetPrice);
        }

        /* Linked List Based Testing */
        UnorderedList<Car> carList = new UnorderedList<>();
        carList.addToFront(new Car("Lexus", "IS250", 2018, 15000));
        carList.addToFront(new Car("Toyota", "Camry", 2018, 20000));
        carList.addToFront(new Car("Peugeot", "206", 2018, 25000));
        carList.addToRear(new Car("Volkswagen", "Golf", 2018, 30000));
        carList.addToRear(new Car("Lamborghini", "Aventador", 2018, 35000));

        Iterator<Car> iterator = carList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        targetPrice = 30000;
        //found = SortingAndSearchingList.linearSearch(carList, new Car("", "", 0, targetPrice));


        /* WARNING
         *
         * THE CODE ABOVE IS NOT WORKING PURPOSELY BECAUSE THE
         * BINARY SEARCH METHOD P.E. IN THE SortingAndSearchingList CLASS
         * DOESN'T MAKE SENSE IMPLEMENTING IT FOR A LINKED LIST
         * BECAUSE IT INCREASES THE TIME COMPLEXITY OF THE ALGORITHM
         */



    }
}
