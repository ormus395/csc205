public class hw2 {
   public static void main(String[] args) {
// just for shits
   }

   double doCalculations(double velocity, double time) {
      final double GRAVITY = 32.174;
   
      return -1.0 * ((Math.pow(time, 2.0) * GRAVITY) / 2) + time * velocity; 
      
   }
}

