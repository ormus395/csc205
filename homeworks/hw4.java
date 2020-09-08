class Main {
   public static void main(String[] args) {
      int[] numbers = {1,2,1,1};

      System.out.println(matchIntsInArray(numbers, 0));
   }

   public static int[] matchIntsInArray(int[] numbers, int numberToMatch) {
      int matchCount = 0;

      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] == numberToMatch) {
            matchCount++;
         }
      }

      if(matchCount < 1) {
         return null;
      }

      int[] matchedLocations = new int[matchCount];
      int matchedLocationsIndex = 0;
      
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] == numberToMatch) {
            matchedLocations[matchedLocationsIndex] = i;
            matchedLocationsIndex++;
         }
      }

      return matchedLocations;
   }
}