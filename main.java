import java.util.Scanner;
// More packages may be imported in the space below
import java.io.File;
import java.io.FileNotFoundException;

class BenfordsLaw{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, salesReport, fraudCheck, exitCondition;
        salesReport = "3";
        fraudCheck = "4";
        exitCondition = "9";

        // More variables for the main may be declared in the space below

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(salesReport)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                int[] digitFrequency = totalSalesReport(reader);
            }
            else if (userInput.equals(fraudCheck)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                
            }
            else{

                if (userInput.equals(exitCondition)){
                }
                else{
                    System.out.println("Please type in a valid option (A number from 1-9)");
                }
            }
        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }

    
    public static int[] totalSalesReport(Scanner reader){
        try {
            // Creates file variable with sales file
            File File = new File("sales.csv");
            // Initializes scanner for the file
            reader = new Scanner(File);
            // Initialize variabe "data", which will hold the string data from the file
            String data = "";
            int firstLineSkipper = 1;
            int totalSalesCount = 0;
            int[] digitFrequencyNum = new int[9]; 
            // Creates loop where it repeats while there are lines to go through
            while (reader.hasNextLine()) {

                if (firstLineSkipper == 1){
                    data = reader.nextLine();
                    firstLineSkipper = 0;
                }
                else{
                    // Variable "data" takes the data from the current line
                    data = reader.nextLine();
                    // Finds the length of the line
                    int len = data.length();

                    // Finds the sale value number
                    String saleString = data.substring(4, len);
                    // Takes the first digit from the number
                    String firstDigitString = saleString.substring(0,1);
                    // Turns the sale number and the first digit into an integer
                    int saleNum = Integer.parseInt(saleString);
                    int firstDigit = Integer.parseInt(firstDigitString);
                    // Adds next sale value to the total sales count
                    totalSalesCount += saleNum;
                    
                    // Adds a count to an array that holds the frequencies of each digit
                    digitFrequencyNum[firstDigit - 1] += 1;
                }
            }

            System.out.println();
            System.out.println("Total Sales: $" + totalSalesCount);
            System.out.println();
            
            // Close Reader
            reader.close();
            // Returns digit frequencies
            return digitFrequencyNum;
        }
        // If file is not found
        catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not located.");
            e.printStackTrace();
        }
        return null;
    }
  
}