import java.util.Random;
import java.util.Scanner;

public class Test {
  
      // Main Method, accepts console arguments if needed.
  
    public static void main(String[] args) {
      
      // Creating scanner object
      
      Scanner input = new Scanner(System.in);
      
         while(true){
       System.out.println("\n\nFor Administrator\n================\n\nWhat type of item?");
       String jaritem = input.nextLine();
       if(jaritem.length() == 0 ||jaritem == " "){
         System.out.println("Item cannot be empty, please try again");
       } else{
       System.out.printf("item: %s", jaritem);
       break;
       }
     }
      
      //Testing java Scanner for interger
      
     System.out.println("\nEnter a Number :"); 
      
     int num = input.nextInt();
      
     System.out.printf("The number you entered is: %d\n", num);
      
     //Testing java Scanner for charater
      
     System.out.println("Enter a Charater: ");
      
     char c = input.next().charAt(0);
      
     System.out.printf("The character you entered is: %c\n", c);
      
     //Testing java Scanner for string
      
     System.out.println("Enter a String: ");
      
     String str = input.next();
      
     System.out.printf("The String you entered is: %s\n", str);
     
     
    }
}