import java.util.Scanner;

class program2 {

   public static void main(String[] args) {
      /*
         Write a program to predict population growth.  For example, let's assume we have a bunny farm 
         and we want to calculate how fast our herd of bunnies is growing. 

         First, ask the user for the number of bunnies that the farm can comfortably support.  
         (This is the 'carrying capacity' of the farm; above that number, bunnies start dying from overcrowding.)
         Then your  program will be able answer both of the following kinds of questions:
               (1)  How many bunnies will I have after this many months?
               (2)  How many months will I have to wait to get this many bunnies?
         Let the user choose which one to answer.  
         Then ask the user for the information necessary to answer the question.  
         After answering each question, ask the user whether they want to ask another question 
         for that farm (with the same carrying capacity).  
         If they want to ask another question, then ask for all the information again (except for the carrying capacity).  
         When they are done asking questions about that farm, ask the user if they want to try another farm.  
         If they do, then ask them for the carrying capacity and repeat the whole process for any number of farms.  
         Otherwise, stop the program
      */

      int capacity = 0;
      int initialPop = 0;
      int months = 0;
      int questionSelected;
      int desiredPopulation;

      double birthRate;
      double deathRate;

      boolean displayTable = false;

      Scanner kb = new Scanner(System.in);

      System.out.println("Bunny Farm Calculator: Determine a Bunny farm population on capacity, death rate, birth rate,");
      System.out.println("and an initial population.");
      System.out.println();
      System.out.println("Additonaly determines the amount of time to reach a given population.");
      
      // determine farm capacity
      System.out.println("Please enter the capacity for your dream Bunny Farm: ");
      capacity = kb.nextInt();
      // determine which question the user would like answered
      System.out.println("Please select which question you would like answered (Enter 1 or 2).");
      // question 1) How many bunnies  will I have after this many months
      System.out.println("1) How many bunnies will I have after this many months?");

      // question 2) How many months will I have to wait to get this many bunnies
      System.out.println("2) How many months will I have to wait to get this many bunnies?");

      questionSelected = kb.nextInt();

      // dont forget to do error handling and authentication for user input     

      System.out.println("Please enter an amount of bunnies you would like your farm to start with: ");
      initialPop = kb.nextInt();

      System.out.println("Next, please enter a positive number for birth Rate: ");
      birthRate = kb.nextDouble();
      
      System.out.println("Please enter a positive number between 1 and 0 (1 and 0 inclusive): ");
      deathRate = kb.nextDouble();

      double growthRate = birthRate - deathRate;
      
      if(questionSelected == 1) {
         System.out.println("Please enter the months for question 1: ");
          months = kb.nextInt();
         System.out.println("Would you like the data printed in a table?");

         System.out.println(popForGivenMonths(months, capacity,growthRate, initialPop));
      } else {
         System.out.println("Please enter the desired population for question 2: ");
         desiredPopulation = kb.nextInt();
         monthsForGivenPop(desiredPopulation, initialPop, growthRate, capacity);
      }

      kb.close();
   }

   // subprogram 1
   // this program will calculate the bunny population
   // after a given period of months
   public static int popForGivenMonths(int months, int capacity, double growthRate, int currentPop) {
      int pNew = 0;
      int pOld = currentPop;


      for(int i = 0; i < months; i++) {

         // calculate Bold
         double bOld = (double)pOld / (double)capacity;

         // calculate Bnew
         double bNew = bOld + (growthRate * bOld) * (1.0 - bOld);

         pNew = (int)Math.rint(bNew * capacity);
         pOld = pNew;
      }
      
      return pNew;
   }

   // subprogram 2
   // this method determines the amount of time required
   // to grow a given amount of bunnied
   public static void monthsForGivenPop(int population, int initialPop, double growthRate, int capacity) {
      // do stuff

      /*
         if the equation for monthly pop equation is 
         Bnew = Bold + gBold(1 - Bold);
         Bold = Pold / 200
         g = birthRate - deathRate
         Pnew = Bnew * 200 
      */

      // easiest way would be to do above calculation with a counter
      // for every month just count up one
      // when the Pnew = population, return the counter

      int monthCount = 0;
      int pNew = 0;
      int pOld = initialPop;

      while(pNew < population) {
         // do the month equation

         // calculate Bold
         double bOld = (double)pOld / (double)capacity;

         // calculate Bnew
         double bNew = bOld + (growthRate * bOld) * (1.0 - bOld);

         pNew = (int)Math.rint(bNew * capacity);
         pOld = pNew;
         System.out.println("Pnew " + pNew);
         monthCount++;
         // add to monthCount
      }

      // return month count
      System.out.println(monthCount);
   }
   // subprogram 3
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