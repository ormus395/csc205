import java.util.Scanner;

class program2 {

   public static void main(String[] args) {

      int capacity = 0;
      int initialPop = 0;
      int months = 0;
      int questionSelected;
      int desiredPopulation;

      double birthRate;
      double deathRate;

      boolean displayTable = false;
      boolean doAnotherFarm = true;
      boolean askAnotherQuestion = true;

      Scanner kb = new Scanner(System.in);
      String tableAnswer = "";

      logger("Bunny Farm Calculator: Determine " + 
         "a Bunny farm population on capacity, death rate, birth rate,", true);
      logger("and an initial population.", true);
      logger("Additonaly determines the amount of time to reach "  
         + "a given population.", true);
      logger("", true);

      // need to create a while loop to allow the user to ask a question more than once, but with the same farm
      // but also need to give the user the ability to create a new far

      
      while(doAnotherFarm){
         // determine farm capacity
         logger("Please enter the capacity for your dream Bunny Farm: ", false);
         capacity = kb.nextInt();

         while(!isPositive(capacity)) {
            logger("The farms capacity must be a positive number.", true);
            kb.nextLine();
            logger("Please enter another number for capacity: ", false);

            capacity = kb.nextInt();
         }

         logger("", true);

         askAnotherQuestion = true;

         while(askAnotherQuestion) {
            // determine which question the user would like answered
            logger("Please select which question you would like " 
               + "answered (Enter 1 or 2).", true);
            // question 1) How many bunnies  will I have after this many months
            logger("    1) How many bunnies will I have after this " 
               +  "many months?", true);

            // question 2) How many months will I have to wait to get this many bunnies
            logger("    2) How many months will I have to wait to " 
               + "get this many bunnies?", true);

            questionSelected = kb.nextInt();

            while(questionSelected != 1 && questionSelected != 2) {
               logger("You did not enter a valid option.", true);
               logger("Please select which question you would like " 
                  + "answered (Enter 1 or 2).", true);
               logger("    1) How many bunnies will I have after this " 
                  +  "many months?", true);
               logger("    2) How many months will I have to wait to " 
                  + "get this many bunnies?", true);

               questionSelected = kb.nextInt();
            } 

            logger("Please enter an amount of bunnies you would like " 
               + "your farm to start with: ", false);
            initialPop = kb.nextInt();

            while(!isPositive(initialPop)) {
               logger("You can't have negative bunnies silly.", true);

               logger("Please enter an amount of bunnies you would like " 
                  + "your farm to start with: ", false);
               initialPop = kb.nextInt();
            }

            logger("Please enter a positive number for birth Rate: ", false);
            birthRate = kb.nextDouble();
      
            while(!isPositive(birthRate)) {
               logger("We can't have sterile bunnies...", true);

               logger("Please enter a positive number for birth Rate: ", false);
               birthRate = kb.nextDouble();
            }

            logger("Please enter a positive number between 0 and 1: ", false);
            deathRate = kb.nextDouble();

            while(!isPositive(deathRate) || (deathRate > 1)) {
               logger("Please enter a positive number between 0 and 1: ", false);
               deathRate = kb.nextDouble();
            }

            double growthRate = birthRate - deathRate;
      
            if(questionSelected == 1) {
               logger("Please enter the months for question 1: ", false);
               months = kb.nextInt();
               while(!isPositive(months)) {
                  logger("I'm sorry, but we dont have a time machine.", true);

                  logger("Please enter the months for question 1: ", false);
                  months = kb.nextInt();
               }
            
               kb.nextLine();

               logger("Would you like the data printed in a table? ", true);

               tableAnswer = kb.nextLine().toLowerCase();
         
               if(tableAnswer.equals("yes") || tableAnswer.equals("y")) {
                  displayTable = true;
                  popForGivenMonths(
                     months, 
                     capacity, 
                     growthRate, 
                     initialPop, 
                     displayTable
                  );
               } else {
                  popForGivenMonths(
                     months, 
                     capacity,
                     growthRate, 
                     initialPop, 
                     displayTable
                  );
               }
         
            } else {
               logger("Please enter the desired population " 
                  + "for question 2: ", true);
               desiredPopulation = kb.nextInt();

               while(!isPositive(desiredPopulation) && desiredPopulation < initialPop) {
                  logger("Please expect more than the starting pop.", true);

                  logger("Please enter the desired population " 
                     + "for question 2: ", true);
                  desiredPopulation = kb.nextInt();
               }

               kb.nextLine();

               monthsForGivenPop(
                  desiredPopulation, 
                  initialPop, 
                  growthRate, 
                  capacity
               );
            }

            logger("Would you like to ask another question for this farm? ", true);

            String answerForAnother = "";
            answerForAnother = kb.nextLine().toLowerCase();

            logger(answerForAnother, true);

            if(!answerForAnother.equals("y") && !answerForAnother.equals("yes")) {
               askAnotherQuestion = false;
            }
         }

         logger("Would you like to do another Farm?", true);

         String answerForAnotherFarm = "";
         answerForAnotherFarm = kb.nextLine().toLowerCase();

         logger(answerForAnotherFarm, true);

         if(!answerForAnotherFarm.equals("y") && !answerForAnotherFarm.equals("yes")) {
            doAnotherFarm = false;
         }
      }

      kb.close();
   }

   // subprogram 1
   // this program will calculate the bunny population
   // after a given period of months
   public static void popForGivenMonths(
      int months, 
      int capacity, 
      double growthRate, 
      int currentPop, 
      boolean displayTable
   ) 
   {
      int pNew = 0;
      int pOld = currentPop;

      if(displayTable) {
         logger("---------------", true);
         logger("| month | Pop |", true);
         logger("---------------", true);
      }
      for(int i = 0; i < months; i++) {

         // calculate Bold
         double bOld = (double)pOld / (double)capacity;

         // calculate Bnew
         double bNew = bOld + (growthRate * bOld) * (1.0 - bOld);

         pNew = (int)Math.rint(bNew * capacity);
         pOld = pNew;

         if(displayTable) {
            logger("| " + (i + 1) + "     | " + pNew + " |", true);
            logger("---------------", true);
         }

      }
      
      logger("The population after " + months + " months is: " + pNew, true);
      logger("", true);
   }

   // subprogram 2
   // this method determines the amount of time required
   // to grow a given amount of bunnied
   public static void monthsForGivenPop(
      int population, 
      int initialPop, 
      double growthRate, 
      int capacity) 
   {

      int monthCount = 0;
      int pNew = 0;
      int pOld = initialPop;

      while(pNew + 1 <= population) {
         // do the month equation
         logger("I am in a loop", true);
         // calculate Bold
         double bOld = (double)pOld / (double)capacity;

         logger("pnew " + pNew, true);

         // calculate Bnew
         double bNew = bOld + (growthRate * bOld) * (1.0 - bOld);

         logger("bnew " + bNew, true);

         pNew = (int)Math.rint(bNew * capacity);

         logger("pnew again " + pNew, true);

         pOld = pNew;

         monthCount++;
         // add to monthCount
      }

      // return month count
      logger("It would take approximately " + monthCount + " months.", true);
      logger("", true);
      
   }

   // subprogram 3
   /*
Check every user input for errors: initial population, carrying capacity, and number of months must be positive numbers.  
The goal population must be greater than or equal to the initial population and less than the carrying capacity.  
The birth rate must be non-negative (positive or zero).  
The death rate must be a number between 0 and 1 inclusive (1 and 0 are okay too).  
Also check every option for a valid entry
   */

   public static boolean isPositive(int userInput) {
      return userInput > 0;
   }

   public static boolean isPositive(double userInput) {
      return userInput >= 0.0;
   }

   // subprogram 4
   public static void logger(String message, boolean nextLine) {
      if(nextLine) {
         System.out.println(message);
      } else {
         System.out.print(message);
      }
   }
}

/*
   first ask how many bunnies the far mcan comfortably support
   then answer 2 questions
      1) How many bunnies  will I have after this many months
      2) How many months will I have to wait to get this many bunnies

   Input/Output
      initial population (how many bunnies to start with)
      birth rate
      death rate
      farm carrying capacity

      if the user selected question 1
         length of time, then computes final size of the population
      if question 2 is selected
         desired size of bunnie population and computes length of time to get there

   Error handling
      check every input for errors
         initial population, carrying capacity, number of months bust be > 0
         goal population must be greater than or equal to the initial population and less than the carrying capacity.
         The birth rate must be >= 0
         Death reate must be a number between 0 and 1 inclusive (1 and 0 are okay)

   outputs
      in addition to displaying the answer to the users question, 
         your program should give the option to have the monthly growth displayed in a table.
      This should have at least two columns: month and number of bunnies

      TABLE MUST BE OPTIONAL
   
   Ease of use
      start with message of how and what the program does
      afterwards include enough information in each input prompt
      label the results thoroughly as well, include the units if appropriate

   Implementation
      use scanner class for all input and println or print for all output
      only one class
      at least two subprograms (methods) 
      the subprograms MUST match the specifications EXACTLY
         FIRST subprogram compute and return number of bunnies after length of time
         SECOND subprogram compute (and return) the length of time to achieve a given number of bunnies.
         Both programs will receive initial population, growth rate and carrying capacity, and wether or not the user wants the table of monthly results

         Another subprogram that asks the user to repeat an entry until its positive
   

   
*/