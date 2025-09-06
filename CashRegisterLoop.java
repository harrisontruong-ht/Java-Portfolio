//import necessary libraries
import java.util.*;
import java.util.Scanner;

public class firstproject {
    public static void main(String[] args) {

        //keep track of total amount
        double total = 0.0;

        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //prompt user to enter input
        System.out.print("How many items?: ");
        int n = sc.nextInt();
        
        //loop through number of items
        for(int i=0; i<n; i++){
            boolean validInput = false;

            //temporary vairable to catch input
            String input = null;

            //prompt user to enter cost of item(s)
            while(validInput != true) {
                System.out.print("Enter the cost of item #" + (i+1) + ": $");
                input = sc.next();
                
                //check if input is valid and adds to total if true
                if(checkValue(input) == true) {
                    total += Double.parseDouble(input);
                    validInput = true;
                }
                else {
                    System.out.print("Invalid input. Please enter a number with exactly two decimal places: $");
                }
            }
        }

        //display subtotal, tax, and total
        System.out.println("\nSubtotal: $" + String.format("%.2f", total));
        System.out.println("Tax(7.75%): $" + String.format("%.2f", total * 0.0775));
        System.out.println("Total: $" + String.format("%.2f", total*1.0775) + "\n");

        //prompt user for payment method
        System.out.print("Cash or credit? 'C' for cash or 'T' for credit: ");
        String paymentMethod = sc.next();

        //validate payment method input
        while((!paymentMethod.equalsIgnoreCase("C")) && (!paymentMethod.equalsIgnoreCase("T"))) {
            System.out.print("Invalid input. Please enter 'C' for cash or 'T' for credit: ");
            paymentMethod = sc.next();
        }

        //process payment based on method
        if (paymentMethod.equalsIgnoreCase("C")) {
            
            //prompt user for cash amount
            System.out.print("Enter cash amount: $");
            
            //validate cash input and ensure sufficient funds
            boolean validInput = false;
            Double cash = null;
            
            //checks if input is valid(cash amount)
            while(validInput != true) {
                String input = sc.next();
                if(checkValue(input) == true) {
                    validInput = true;
                    cash = Double.parseDouble(input);
                }
                else {
                    System.out.print("Invalid input. Please enter a number with exactly two decimal places: $");
                }
            }

            //checks if cash amount is sufficient
            while(cash < (Math.round(total * 107.75)/100.0)) {
                System.out.print("Insufficient funds. Please enter a valid amount: $");
                validInput = false;
                while(validInput != true) {
                    String input = sc.next();
                    if(checkValue(input) == true) {
                        validInput = true;
                        cash = Double.parseDouble(input);
                    }
                    else {
                        System.out.print("Invalid input. Please enter a number with exactly two decimal places: $");
                    }
                }
            }

            //display change and complete transaction
            System.out.println("Change: $" + String.format("%.2f", (cash - total * 1.0775)));
            System.out.println("Transaction complete. Thank you!");
            
            //process credit card payment
        } else if (paymentMethod.equalsIgnoreCase("T")) {
            System.out.println("Processing credit card payment...");
            System.out.println("Transaction complete. Thank you!");
        }
    }   

    //function to check if input is a valid number with exactly two decimal places
    public static boolean checkValue(String value) {
    try {
        Double num = Double.parseDouble(value);
        String decimalString = value.substring(value.indexOf('.') + 1);
        if (decimalString.length() == 2) 
        {
            return true;
        }   
        else 
        {
            return false;
        }
      }  
    catch(NumberFormatException e) {
        return false;
      }
    }
}

