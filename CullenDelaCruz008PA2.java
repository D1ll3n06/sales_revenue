/**
*By Amy Cullen and Dillen Dela Cruz
* This program takes input from the user to determine
* sales revenue data for the fictional company of 
* tandem industries. The program gets its data from
* various methods which is executed in the main
*function, and the output is returned in the form 
*of the print method.
*
*The code was made in collaboration over zoom 
*between both students from start to finish. We
*each provided an equal amount of input and feedback.
*Both of us collaboratively worked on this document via
*an online editor and was saved on Dillen Dela Cruz’s
*personal computer for distribution.
*/


import java.util.Scanner; // import the Scanner Library 
import java.util.Calendar; // import the Calendar


public class CullenDelaCruz008PA2 //runs the entire script and calls the appropriate methods
{ //opening header
  
  private static String salesRep, quarter; //declare string variables 
  private static String monthNo = " "; // declare a blank String called monthNO
  
  private static double quarterlySales; //declare double variables
  private static int qtrCounter, noOfQtrs; //declare integer variables
  private static Scanner input = new Scanner(System.in); //create a new scanner system to take input from users
  
  public static void main(String[] args)
    
  { //opening header
   double salesRevenue, annualSales, projectedSales, percOfTargetCo, percOfTargetRep;
   int qtrChoice, monthCounter, noOfMonths, noSalesReps,salesRepCtr; //declares double variables specific to that method


   salesRevenue = 0.0; //sets salesRevenue to 0
   annualSales = 0.0; //sets annaulSales to 0
   salesRepCtr = 0; //sets salesRepCtr to 0
   noOfMonths = 3; // sets noOfMonths to 3
    
    System.out.printf("%nWhat is the projected annual sales for Tandem? "); //Prints out to the output console What is the projected annual sales for Tandem?
    
    
    while (  !input.hasNextDouble() ) //does the following while the input is a whole number and not a double
    { //opening header
      input.next(); // clears the buffer
      System.out.printf("%nNOT a valid integer! Please re-enter the number of sales reps for Tandem:  "); //returns an error message prompting the user to re-enter the value
    }//closing header
     projectedSales = input.nextDouble(); //sets the projected sales value to the user input collected in the while loop
    
    System.out.printf("%nHow many sales reps work for Tandem? "); // prompts the user to ask for a number of sales representatives
  


    while (!input.hasNextInt()) //does the following while the entered value is not an integer
    { //opening header
      input.next(); // clears the buffer
      System.out.printf("%nNot a valid integer! Please re-enter the number of sales for Tandem:  "); //returns an error message prompting the user to re-enter the value
    } //closing header
     noSalesReps = input.nextInt(); // sets noSalesReps to the user input collected in the while loop
     
    do //creates a do loop
    { //opening header
      qtrCounter = 1; //sets qtrCounter to 1
      quarterlySales = 0.0; //sets quarterly sales to 0
      
      salesRepCtr++; //increases salesRepCtr be 1
 
 input.nextLine(); // clears the buffer
      promptSalesRep(salesRepCtr); //calls the promptSalesRep method using the salesRepCtr as the integer value
      promptNoQtrs(); //calls the promptNoQtrs method using no input values
      
      while(qtrCounter <= noOfQtrs) //while the qtrCounter is less than or equal to noOfQtrs the following will run
      { //opening header
        monthCounter = 1; //sets monthCounter to 1
        chooseQtr(); //calls the chooseQtr method
        
         while (monthCounter <= noOfMonths) //while the monthCounter is greater than or equal to noOfMonths the following will execute
         { //opening header
           determineMonthNo(monthCounter); //calls the determineMonthNO using the monthCounter as the integer value
           salesRevenue = promptSalesRevenue(); //sets the salesRevenue variable equal to the output of the promptSalesRevenue
           
           quarterlySales += salesRevenue; //adds salesRevenue to quarterlySales
           ++monthCounter; //increases the monthCounter by 1
           
         } // closing header
         
         annualSales += quarterlySales; //adds quarterlySales to annualSales
         ++qtrCounter; //increases qtrCounter to one
      } // closing header
      
     printSalesRepRevReport(); //calls the printSalesRepRevReport which showcases the final values
     
     percOfTargetRep = quarterlySales /  (projectedSales/noSalesReps) * 100;//calculates the perc of the target representative by taking quarterlySales and dividing it by the projectedSales divided by the number of representatives and then multiply that value by 100 to return a percentage      
          if (noOfQtrs < 4) // if the number of quarters is greater than 4 then the following happens
          { //opening header
             if (percOfTargetRep >= 50) //checks if the calculated perc is greater than or equal to 50
                 { //opening header
                System.out.printf("%nKeep up the GOOD work, %s. " 
                                  + "There is a possible year-end bonus!%n",
                                  salesRep.substring(0,salesRep.indexOf(' ')).substring(0,1).toUpperCase()
                                 + salesRep.substring(1, salesRep.indexOf(' ')));//outputs a closing statement congratulating the user
                }//closing header
              else // if the above if statement is not true this happens instead
               { //opening header
               System.out.printf("%nSo far sales are lagging behind projections.%n"); //outputs to the program execution terminal that sales are lagging behind projections
               } //closing header
    
          } //closing header


          
     } //closing header
     while (salesRepCtr < noSalesReps); //checks if the salesRepCounter is less then the number of sales representatives and executes the following
          
      percOfTargetCo = (annualSales/projectedSales) * 100; //sets the percOfTargetCo to be equal to annualSales and divides it by projected sales, then multiples it by 100 to convert it to a fraction.
    
      System.out.printf("%nCORPORATE SALES PERFORMANCE%n");  //outputs the sales performance title
      System.out.printf("%n%s%n", percOfTargetCo >= 100? "It's been a GOOD year so far, There could be a year-end " +
                     "bonus of about 2-5% if we can keep on top of our sales goals." +
                     "Thank you all and please continue your exce11llent effort!": "Sales are lagging projections. A year-end bonus may not be possible." ); //outputs the ending statement to the program execution terminal
      
     
     System.exit(0); //ends the user program returning that there was no error at all in execution
    
  } //closing header


    public static void promptSalesRep(int salesRepCtr)//creates a new method called promptsalesRep, asking the user for an integer, which will be labeled as salesRepCtr
  { //opening header
    int index, spaceCount; //creates two integers to be used in the method
    spaceCount = 0; //sets spaceCount to 0
    StringBuilder rep; //modifies the String value of rep


    System.out.printf("%nEnter the firstname and lastname of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next"); //prompts the user to enter the name of a sales representative
    
    salesRep = input.nextLine(); //sets the user input to the variable salesRep
      
    for(char blank : salesRep.toCharArray()) //loops the following for each character in the salesRep string
    { //opening header
        if(blank == ' ') { //checks if there is a blank value for that instance in the salesRep string
            spaceCount++; //increases spaceCount by 1
        }//END if there is a blank
    }//END for counting blanks in 
  
    rep = new StringBuilder(salesRep); // creates a new StringBuilder and stores it in the variable rep
    rep.setCharAt(0, salesRep.toUpperCase().charAt(0)); //Sets the first character in the string to an uppercase value
    index = salesRep.indexOf(' '); //sets the index value to the first instance of a space in the string value


  
    for(int i = 1; i <= spaceCount; i++) // executes the following code while the created value of i is less than space count, increasing the value each time by 1
    { //opening header
        rep.setCharAt(++index, salesRep.toUpperCase().charAt(index)); //takes the character at the current index position in the salesRep string, converts it to uppercase, and returns it, while also incrementing the index by 1
        index = salesRep.indexOf(' ', index); // finds the next blank index in the salesRep String
    }//END for i from 1 thru spaceCount salesRep = rep.toString();


    salesRep = rep.toString(); //assigns salesRep to the converted variable 
  } //ending header


  public static void promptNoQtrs () //creates a new method called promptNoQtrs that takes no input values
  { // starting header
    System.out.printf("%nEnter the number of quarters worked (no less than 1 or greater than 4): "); //prompts the user to enter a specific number of quarters


     while ( !input.hasNextInt() ) //executes while input is not an integer
      { //starting header
        input.next();// clears the buffer
        System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): "); //prompts the user to re-enter the value as it is not one in the specified range
      } //closing header


      noOfQtrs = input.nextInt(); //sets noOfQtrs to the input collected above


     while (!(noOfQtrs >=1 && noOfQtrs <=4))  //while the quarter chosen is not between 1 and 4 the following will happen
        {
          System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): "); //prompts the user that the input specified is not correct


  while ( !input.hasNextInt()) //while the quarter chosen is not an integer
       {   
          input.next(); //clears buffer
          System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): ");//prompts the user that the input specified is not correct


      }


          noOfQtrs = input.nextInt(); //sets the qtrChosen value to the user input


  }




  } //closing header



  public static int chooseQtr() //creates a method called chooseQtr taking no input values
  { //opening header
      int qtrChosen = 0; // creates an integer value specific to this method called qtrChosen
      
      System.out.printf("%n1. First Quarter%n"
                    + "2. Second Quarter%n"
                    + "3. Third Quarter%n"
                    + "4. Fourth Quarter"
                        
                    + "%n%nChoose the %s quarter in which sales were earned: ", qtrCounter > 1 ? "next" : ""); //prompts the user to choose a quarter with the appropriate quarter number
    


     while ( !input.hasNextInt() ) //while the quarter chosen is less than 1 or greater than 3 and the input is not an integer the following will happen
    { //opening header
       input.next(); //clears the buffer
       System.out.printf("%nNOT a valid integer! Please re-enter the quarter.%n"); //prompts the user that the input specified is not correct

       System.out.printf("%n1.First Quarter%n"
                    + "2. Second Quarter%n"
                    + "3. Third Quarter%n"
                    + "4. Fourth Quarter"
                        
                    + "%n%nChoose the %s quarter in which sales were earned: ", qtrCounter > 1 ? "next" : ""); //prompts the user to choose a quarter with the appropriate quarter number
      
    } //ending header
    qtrChosen = input.nextInt(); //sets the qtrChosen value to the user input


 while (!(qtrChosen >=1 && qtrChosen <=4)) //while the quarter chosen is not between 1 and 4 the following will happen
        {
          
          System.out.printf("%nNOT a valid integer! Please re-enter the quarter.%n"); //prompts the user that the input specified is not correct
           System.out.printf("%n1. First Quarter%n"
                    + "2. Second Quarter%n"
                    + "3. Third Quarter%n"
                    + "4. Fourth Quarter"
                        
                    + "%n%nChoose the %s quarter in which sales were earned: ", qtrCounter > 1 ? "next" : ""); //prompts the user to choose a quarter with the appropriate quarter number

          
          while ( !input.hasNextInt())
              {
                  input.next();//clears buffer
                  System.out.printf("%nNOT a valid integer! Please re-enter the quarter.%n"); //prompts the user that the input specified is not correct
                   System.out.printf("%n1. First Quarter%n"
                    + "2. Second Quarter%n"
                    + "3. Third Quarter%n"
                    + "4. Fourth Quarter"
                        
                    + "%n%nChoose the %s quarter in which sales were earned: ", qtrCounter > 1 ? "next" : ""); //prompts the user to choose a quarter with the appropriate quarter number
             }




          qtrChosen = input.nextInt(); //sets the qtrChosen value to the user input
        }


    
    quarter = (qtrChosen == 1) ? "First Quarter" : (qtrChosen == 2) ? "Second Quarter": (qtrChosen == 3)? "Third Quarter" : "Fourth"; //converts the chosen quarter in to a string


      return  qtrChosen; //returns the qtrchosen value to any method that calls it
  } //ending header



  public static void determineMonthNo(int monthCounter) //creates a method called determineMonthNo, asking for a single integer called monthCounter
  { //opening header
   
    
      switch(monthCounter) //creates a switch case checking for each instance of monthCounter
      { //opening header
        case 1:  //when the monthCounter value is equal to 1
          monthNo = "1st"; //sets the monthNo variable to "1st"
          break; //exits the switch case
        case 2: //when the monthCounter value is equal to 2
          monthNo = "2nd"; //sets the monthNo variable to "2nd"
          break;//exits the switch case
        case 3:  //when the monthCounter value is equal to 3
          monthNo = "3rd"; //sets the monthNo variable to "3rd" 
          break; //exits the switch case
        } //closing header


  } //closing header
  
 public static double promptSalesRevenue() //creates a method called promptSalesReveune taking no input
  { //opening header
    double salesRev; //creates a double value called salesRev


    
    System.out.printf("%nEnter the sales revenue for the %s month of the %s: ", monthNo, quarter); //prompts the user to enter the sales revenue for the month in the monthNo value, while also also stating the quarter


      while ( !input.hasNextDouble() ) //while the input is not a double value
      { //opening header
      input.next(); //clears the buffer
      System.out.printf("%nNOT a valid floating-point!%n"); //states the entered value is not a valid floating point
      System.out.printf("%nPlease re-enter the sales revenue for the %s month of the %s: ", monthNo, quarter); //prompts the user to reenter their value
      } //closing header
      salesRev = input.nextDouble(); //sets sales revenue to the double value created above
    
    return salesRev; //returns the value of salesRev
  } //closing header




   public static void printSalesRepRevReport() //creates a method called printSalesRevRepot to output the final method
   { //opening header
    Calendar dateTime = Calendar.getInstance(); //calls the calendar library to create a calendar method to be used in this method
   
    System.out.printf("%nTANDEM ENTERPRISES%n"); //outputs1 the company name
    System.out.printf("SALES REVENUE FOR %d QUARTER(S) OF %s",noOfQtrs,dateTime.get(Calendar.YEAR)); //outputs the company revenue stating the number of quarters and the year from the calendar library
    System.out.printf("%nSALES REP: %s%n",salesRep); //outputs the sales representative's name
    System.out.printf("%nTotal Year-To-Date:    %s\t%,.2f%n",'$',quarterlySales); // outputs the quarterlySales
  } //closing header
} //closing header

/**
* What is the projected annual sales for Tandem?  [DrJava Input Box]
* 
*NOT a valid integer! Please re-enter the number of sales reps for Tandem:   [DrJava Input Box]
* 
*How many sales reps work for Tandem?  [DrJava Input Box]
* 
*Not a valid integer! Please re-enter the number of sales for Tandem:   [DrJava Input Box]
* 
*Enter the firstname and lastname of a sales rep:  [DrJava Input Box]
* 
*Enter the number of quarters worked (no less than 1 or greater than 4):  [DrJava Input Box]
* 
*NOT a valid integer! Please re-enter the number of quarters worked (1-4):  [DrJava Input Box]
* 
*1. First Quarter 
*2. Second Quarter 
*3. Third Quarter 
*4. Fourth Quarter 
* 
*Choose the  quarter in which sales were earned:  [DrJava Input Box]
* 
*NOT a valid integer! Please re-enter the quarter. 
* 
*1.First Quarter 
*2. Second Quarter 
*3. Third Quarter 
*4. Fourth Quarter 
* 
*Choose the  quarter in which sales were earned:  [DrJava Input Box]
* 
*Enter the sales revenue for the 1st month of the Second Quarter:  [DrJava Input Box]
* 
*NOT a valid floating-point! 
* 
*Please re-enter the sales revenue for the 1st month of the Second Quarter:  [DrJava Input Box]
* 
*Enter the sales revenue for the 2nd month of the Second Quarter:  [DrJava Input Box]
* 
*Enter the sales revenue for the 3rd month of the Second Quarter:  [DrJava Input Box]
* 
*TANDEM ENTERPRISES 
*SALES REVENUE FOR 1 QUARTER(S) OF 2023 
*SALES REP: Julian Caesar 
* 
*Total Year-To-Date:    $ 250,000.00 
*
*Keep up the GOOD work, Julian. There is a possible year-end bonus! 
* 
*Enter the firstname and lastname of the next sales rep:  [DrJava Input Box]
* 
*Enter the number of quarters worked (no less than 1 or greater than 4):  [DrJava Input Box]
* 
*1. First Quarter 
*2. Second Quarter 
*3. Third Quarter 
*4. Fourth Quarter 
* 
*Choose the  quarter in which sales were earned:  [DrJava Input Box]
* 
*Enter the sales revenue for the 1st month of the First Quarter:  [DrJava Input Box]
* 
*Enter the sales revenue for the 2nd month of the First Quarter:  [DrJava Input Box]
* 
*Enter the sales revenue for the 3rd month of the First Quarter:  [DrJava Input Box]
* 
*1. First Quarter 
*2. Second Quarter 
*3. Third Quarter 
*4. Fourth Quarter 
* 
*Choose the next quarter in which sales were earned:  [DrJava Input Box]
* 
*Enter the sales revenue for the 1st month of the Second Quarter:  [DrJava Input Box]
* 
*Enter the sales revenue for the 2nd month of the Second Quarter:  [DrJava Input Box]
*
*Enter the sales revenue for the 3rd month of the Second Quarter:  [DrJava Input Box]
* 
*TANDEM ENTERPRISES 
*SALES REVENUE FOR 2 QUARTER(S) OF 2023 
*SALES REP: Monique La Femme 
* 
*Total Year-To-Date:    $ 32,000.00 
* 
*So far sales are lagging behind projections. 
* 
*CORPORATE SALES PERFORMANCE 
* 
*Sales are lagging projections. A year-end bonus may not be possible. 
*> 
*/




