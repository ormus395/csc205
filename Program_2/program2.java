import java.util.Scanner;

class program2 {

   public static void main(String[] args) {

      int capacity = 200;
      int birthRate = 0;
      int deathRate = 0;
      int initialPop = 50;
      int months = 24;
      Scanner kb = new Scanner(System.in);

      System.out.println("Please enter a positive number for birth Rate: ");

      birthRate = kb.nextInt();
      System.out.println("Please enter a positive number for the death rate: ");
      deathRate = kb.nextInt();

      int growthRate = birthRate - deathRate;
      System.out.println(popForGivenMonths(months, capacity,growthRate, initialPop));

      kb.close();
   }

   // subprogram 1
   // this program will calculate the bunny population
   // after a given period of months
   public static int popForGivenMonths(int months, int capacity, int growthRate, int currentPop) {
      // calculation
      // x = current pop / carrying cap + (birth rate - death rate) * ( pop / carrying cap) * (1 - pop / carrying cap)
      // above is the population after a month
      // so to find total pop, calculate the relative pop for a month * given months

      // calculation
      // Pold = the actual numbers of bunnies at the begining of the month
      // Bold = the relative pop of bunnies at the beginning of the month where Bold = Pold / N
      // Bnew = the relative population of bunnies at the end of the month [notice that Pnew = Bnew * N]
      // N = the carry capacity of the habitat
      // g = growth rate (bunnies per bunny per month)

      // P numbers need to be ints
      // B numbers are ratios, so they need to be doubles
      
      // need total population varaible
      // need a varaible for end of month
      // need a varaible to hold last Population
      // need a varaible to hold new Pop
      // need a variable for carryingCapacity
      // need a growth rate variable
      int pNew = 0;
      int pOld = currentPop;


      for(int i = 0; i < months; i++) {
         System.out.println("Pnew at beginning " + pNew);
         System.out.println("Pold at beginning " + pOld);

         // calculate Bold
         double bOld = (double)pOld / (double)capacity;
         System.out.println("Bold " + bOld);

         // calculate Bnew
         double bNew = bOld + (growthRate * bOld) * (1.0 - bOld);
         System.out.println("Bnew " + bNew);

         pNew = (int)Math.rint(bNew * capacity);
         System.out.println("Pnew " + pNew);
         pOld = pNew;
         System.out.println("Pold " + pOld);
      }
      
      return pNew;
   }

   // subprogram 2
   // this method determines the amount of time required
   // to grow a given amount of bunnied
   public void monthsForGivenPop(int population) {
      // do stuff
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
      in addition to displaying the answer to the users question, your program should give the option to have the monthly growth displayed in a table.
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