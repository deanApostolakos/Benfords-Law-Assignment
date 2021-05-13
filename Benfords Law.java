// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock


import java.util.Scanner;
// More packages may be imported in the space below
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class BenfordsLaw{

    public static void main(String[] args){ 
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, customerData, salesReport, fraudCheck, exitCondition;
        customerData = "2";
        salesReport = "3";
        fraudCheck = "4";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        // Create array to store the frequency of each digit (part 1, method 1)
        int[] digitFrequency = new int[9];
        // Create array to store the percent frequency of each digit (part 2, method 2)
        String[] digitFrequencyPercent = new String[9];
        

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(customerData)) {
              
            }
            else if (userInput.equals(salesReport)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                // Call totalSalesReport Method
                digitFrequency = totalSalesReport(reader);

            }
            else if (userInput.equals(fraudCheck)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerData(digitFrequency);
                
                // Call last method
                resultsExport(digitFrequency, digitFrequencyPercent);
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
        .concat("1. Enter Customer Information (Not done in this part)\n")
        .concat("2. Generate Customer data file (Not done in this part)\n")
        .concat("3. Report on total Sales\n")
        .concat("4. Check for fraud in sales data\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }

    /*
     * Method generateCustomerData generates the bar graph
     * @param - digitFrequency
     * @return - void
    */
    public static void generateCustomerData(int[] digitFrequency){
        BarGraph graph = new BarGraph();
        graph.newGraph(digitFrequency);
    }

    /*
     * Method totalSalesReport loads sales data, finds total sales, and counts and stores 
     * the frequency of first digits
     * @param - Scanner reader
     * @return - int[]
    */
    public static int[] totalSalesReport(Scanner reader){
        try {
            // Ask user for file name
            System.out.print("Enter File Name (ex.'filename.filetype'): ");
            String fileName = reader.nextLine();
            // Creates file variable with sales file
            File File = new File(fileName);
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






    /*
     * Method resultsExport exports the digit frequency in a file called results.csv
     * @param - int[] frequency, String[] frequencyPercent
     * @return - void
    */
    public static void resultsExport(int[] frequencyNum, String[] frequencyPercent){
        // Create new file
        String fileName = "results.csv";
        File outFile = new File(fileName);
        // New PrintWriter which will print to the file
        try {
            PrintWriter out = new PrintWriter(outFile);
            // Prints header to file
            out.println("Digit,Frequency,Percent Frequency");
            // Prints each digit and their frequency and percent frequency on a new line each time
            for (int i = 0; i < frequencyNum.length; i++){
                out.println((i+1)+", " + frequencyNum[i]+", " + frequencyPercent[i] + "%");
            }
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
