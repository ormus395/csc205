/**
 * Jarec Turner      CSC205
 * Program 1
 * 
 * Simple hello world program that spits out a simple CV
 */

import java.util.Scanner;

class program1 {

   public static void main(String[] args) {
      System.out.println("This is Jarec's CV.");
      System.out.println("My name is: Jarec Turner. Prior Courses: CSC110");
      System.out.println("Professional background: Web Development and IT.");
      System.out.println("Tools: JDK, VSCode, Windows10, Desktop.");
      System.out.println("Programming Languages: Java, JavaScript, Ruby");
      System.out.println("Goals: To get that degree. Too many places require");
      System.out.println("  a college degree");
      System.out.println("No concerns.");
      System.out.println("Other classes: MAT182 (Trig)");
      System.out.println("Java Battleship game.");
      System.out.println("I really love History. Especially the Roman era.");

      Scanner scanner = new Scanner(System.in);

      int number = scanner.nextInt();

      System.out.println(number);
   }
}