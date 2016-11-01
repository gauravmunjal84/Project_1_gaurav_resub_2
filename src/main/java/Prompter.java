import java.io.Console;
import java.util.Scanner;

public class Prompter{
  
   public static Jar mJar; 
   private static int mIntlimit;
   private static String mJaritem;
   private static int mPlayerguess;
   private static boolean isValid = false;
   private static boolean isPlayerGuessValid = false;
   public  static final int MAX_LIMIT = 9;
  
 
   public Prompter(){}
   
   public boolean isValid(){
    return isValid;
   }
  
   public boolean isPlayerGuessValid(){
    return isPlayerGuessValid;
   }
  
   Scanner scan = new Scanner(System.in);
  
   public void play(){
      //Prompt Administrator, for item
      
          promptItem();
      
      //Prompt Administrator, set max jar capacity
      
          promptAdmin();
           
      //Instantiate Jar Class
      
          initJar(); 
      
      //Prompt Player for Guess
         
         promptPlayer();
         try{
        
           if(mJar.isHit()){
             System.out.printf("You Won ! You got it right in %d attempts\n", mJar.attempts()+1 );
           }
         } catch (IllegalArgumentException iae){
             System.out.printf("Actual number of items in Jar are %d !\n", mJar.getActualNum());
            //  System.out.printf("\nTries Remaining : %d\n", mJar.isChance());
        }
    

     
   //  System.out.printf("\nTries Remaining : %d\n", mJar.isChance());
   /*     if(mJar.isHit()){
          System.out.printf("You Won ! Your Guess was right. There are %d %s in the Jar",mJar.getActualNum(), mJaritem);
        } else{
          System.out.printf("You Lost ! There are %d %s in the Jar",mJar.getActualNum(), mJaritem);
        }
        */
   }
  // Prompt Admin to enter the Jar item
   
   public void promptItem(){
       String jaritem;
       while(true){
       System.out.println("\n\nFor Administrator\n================\n\nWhat type of item?");
       jaritem = scan.nextLine();
       if(jaritem.length() == 0 ||jaritem == " "){
         System.out.println("Item cannot be empty, please try again");
       } else{
        mJaritem = jaritem;
        break;
       }
     }
     mJaritem = jaritem;  
   }
  
  // Prompt Admin to define max capacity for the Jar
  
   private void promptAdmin(){
      int maxlimit;
      while(!isValid()){
        System.out.printf("What is the maximum amount of %s?", mJaritem);
        maxlimit = scan.nextInt();
        try{
          boolean isValidlimit = isValidlimit(maxlimit);
          isValid = true;
        } catch (IllegalArgumentException iae){
              System.out.printf("%s Please enter a positive value between 1 and %d\n", iae.getMessage(), MAX_LIMIT); 
        }
      }
   }
  
  //Logic to validate Admin input, cannot be in Jar.java as it is not instantiated yet.
  
    public boolean isValidlimit(int maxJarlimit){
    int intlimit = maxJarlimit;
    if(intlimit > MAX_LIMIT || intlimit == 0 || intlimit < 0){
      throw new IllegalArgumentException("Entered value must be within permissible limit. ");
      } else{
      mIntlimit = intlimit; 
    //   System.out.printf("Entered Number is: %d", 0mIntlimit);
      return true;
      }
  }
  
  
  
  //Instantiate Jar Object, this is after we have Jar Item and Max Item in the Jar
  
    public void initJar(){
      mJar = new Jar(mJaritem,mIntlimit);
    }
    
    
  // Prompt for Players to guess the quantity
  
   public void promptPlayer(){
     int tries = mJar.isChance();
     int guessedNum;
     while((!isPlayerGuessValid()) &&  (tries > 0) ){
          System.out.printf("\n\nFor Players\n==============\n\nHow many %s are in the jar? Pick a number between 1 and %d: ",                                                                                               mJar.getItem(),mJar.getLimit());
          guessedNum = scan.nextInt();
     try{
         boolean isValidGuess = mJar.isValidGuess(guessedNum);
         boolean isHit = mJar.isHit();
         isPlayerGuessValid = true;
       } catch(IllegalArgumentException iae){
         System.out.printf("%s\n", iae.getMessage()); 
         tries = mJar.isChance();
         System.out.printf("Tries Remaining: %d", mJar.isChance());
       }

   }
  }
  
  
     
       
   public int getIntlimit(){
         int jarLimit = mIntlimit;
          return jarLimit;
        }
      

  
}