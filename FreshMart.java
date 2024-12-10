package viva2;

import java.util.Scanner;
public class FreshMart {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Create a Scanner object for user input

        // Arrays to store available fruits, their storage quantities, and prices per unit
        String[] fruits = {"Apple", "Grape", "Banana", "Mango", "Orange", "Strawberry", "Blueberry"};  
        int[] storage = {45, 57, 75, 34, 75, 65, 78};  
        double[] price = {5.00, 10.00, 2.50, 6.00, 3.00, 15.00, 12.00};  

        // Display available fruits to the user
        printFruit(fruits);  

        // Prompt the user to select a fruit and enter the desired quantity
        System.out.print("Please enter the fruit you want to buy: ");  
        String fruitSelect = in.nextLine();  

        System.out.print("Unit or Box: ");  
        int quantity = in.nextInt();  

        // Get the index of the selected fruit in the fruits array
        int fruitIdx = getIdxFruit(fruits, fruitSelect);  

        // Check if the product is available and if there is enough stock
        if (!haveProduct(fruits, fruitIdx)) {  
            System.out.println("Sorry we currently do not offer this product.");  
        } else if (!haveStock(fruitIdx, storage, quantity)) {  
            System.out.println("Sorry, we do not have enough stock for " + fruits[fruitIdx] + ". Please come again later!");  
        } else {  
            // Generate and display the bill if the product is available and in stock
            System.out.println("\nKindly Checkout here: ");  
            generateBill(fruits, fruitIdx, price, quantity);  
        }  
    }  
    
    // Display the list of available fruits
    public static void printFruit(String[] fruits){
        System.out.println("FreshMart Fruit Selection");
        for(int i = 0; i < fruits.length; i++){
            System.out.println((i + 1) + ". " + fruits[i]);
        }
    }
    
    // Finds the index of the selected fruit in the fruits array
    public static int getIdxFruit(String[] fruits, String selectedFruit){
        for(int i = 0; i < fruits.length; i++){
            if(fruits[i].equalsIgnoreCase(selectedFruit)){
                return i; // Return the index if the fruit name matches
            }
        }
        return -1; // Return -1 if the fruit is not found
    }
    
    // Checks if the selected fruit is available
    public static boolean haveProduct(String[] fruits, int fruitIdx){
        return fruitIdx >= 0 && fruitIdx < fruits.length; // Returns true if the fruit index is valid
    }
    
    // Checks if there is enough stock for the selected fruit
    public static boolean haveStock(int fruitIdx, int[] storage, int quantity){
        return storage[fruitIdx] >= quantity; // Returns true if stock is sufficient
    }
    
    // Generates and prints the bill 
    public static void generateBill(String[] fruits, int fruitIdx, double[] price, int quantity){
        double totalPrice = price[fruitIdx] * quantity; // Calculate total price

        // Print the receipt
        System.out.println("-------------------------------------------------------------");
        System.out.println("-----------------Fresh Mart Receipt-------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-20s %10s %20s%n", "Product", "Quantity", "Price per Unit(RM)");
        System.out.printf("%-20s %10d %20.2f%n", fruits[fruitIdx], quantity, price[fruitIdx]); // Show the selected fruit, quantity, price per unit
        System.out.println("-------------------------------------------------------------");  
        System.out.printf("Total Price: %.2f", totalPrice);  
        System.out.println("\n--------------------------------------------------------------"); 
    }
}
