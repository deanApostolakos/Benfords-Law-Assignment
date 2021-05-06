import java.util.Scanner;
// More packages may be imported in the space below

class BenfordsLaw{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, totalSalesReport, fraudCheck, exitCondition;
        totalSalesReport = "3";
        fraudCheck = "4";
        exitCondition = "9";

        // More variables for the main may be declared in the space below

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(totalSalesReport)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                
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
  
  
}
