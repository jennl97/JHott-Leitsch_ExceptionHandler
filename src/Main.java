import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean validChoice = false;
        /**
         * set menu
         */

        while (!validChoice) {
            System.out.println("1. Residential");
            System.out.println("2. Commercial");
            System.out.println("3. Done");
            System.out.println("Please enter an option from 1-3");

            int userInput = scanner.nextInt();

            /**
             * work through the menu
             */

            switch (userInput){
                case 1:
                    validChoice = true;
                    residential();
                    break;

                case 2:
                    validChoice = true;
                    commercial();
                    break;

                case 3:
                    validChoice = true;
                    System.out.println("Thank you for choosing Acme Lawn Care.");
                    break;

                default:
                    System.out.println("Please enter a number between 1 and 3.");
            }

        }


    }

    /**
     * residential method
     */

    public static void residential(){
        Scanner scannerR = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        String customerName = scannerR.nextLine();
        System.out.println("Enter Customer Phone Number:");
        String phoneNumber = scannerR.nextLine();
        System.out.println("Enter Customer Address:");
        String customerAddress = scannerR.nextLine();
        System.out.println("Enter Square Footage:");
        String squareFootage = scannerR.nextLine();

        Double footage;
        try {
            footage = Double.parseDouble(squareFootage);
        } catch(NullPointerException ex){
            System.out.println("A square footage value is required! We are assuming 1000 square feet.");
            footage = 1000.0d;

        } catch (NumberFormatException ex){
            System.out.println("You did not enter a number. We are assuming 1000 square feet.");
            footage = 1000.0d;
        }

        System.out.println("Are they over the age of 65? Yes or No");
        String seniorQuestion = scannerR.nextLine();
        Boolean isSenior = seniorQuestion.substring(0,1).equalsIgnoreCase("Y");
        Residential customer = new Residential(customerName, phoneNumber, customerAddress, footage, isSenior);
        customer.weeklyCharges();
    }

    /**
     * commercial method
     */

    public static void commercial(){
        Scanner scannerC = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        String customerNameC = scannerC.nextLine();
        System.out.println("Enter Customer Phone Number:");
        String phoneNumberC = scannerC.nextLine();
        System.out.println("Enter Customer Address:");
        String customerAddressC = scannerC.nextLine();
        System.out.println("Enter Square Footage:");
        String squareFootageC = scannerC.nextLine();

        Double footageC;
        try {
            footageC = Double.parseDouble(squareFootageC);
        } catch(NullPointerException ex){
            System.out.println("A square footage value is required! We are assuming 1000 square feet.");
            footageC = 1000.0d;

        } catch (NumberFormatException ex){
            System.out.println("You did not enter a number. We are assuming 1000 square feet.");
            footageC = 1000.0d;
        }

        System.out.println("Enter Property Name:");
        String propertyNameC = scannerC.nextLine();
        System.out.println("Do you have multiple properties? Yes or No");
        String multi = scannerC.nextLine();
        Boolean isMulti = multi.substring(0,1).equalsIgnoreCase("Y");
        Commercial customerC = new Commercial(customerNameC, phoneNumberC, customerAddressC, footageC, propertyNameC, isMulti);
        customerC.weeklyCharges();
    }
}


