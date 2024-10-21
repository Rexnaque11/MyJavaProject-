
package math.calculator;

import java.util.Scanner;

public class MathCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = "Rex";
        int password = 1231;
      
        do{
        System.out.print("Enter username: ");
        String typeUsername = scan.nextLine();
     
            if(typeUsername.equals( username)){
            System.out.print("Enter Password: ");
            int typePassword = scan.nextInt();
         
            switch(typePassword){
                case 1231:
                    System.out.println("MATH CALCULATOR");
                    System.out.println("Enter a number for operation");
                    System.out.println("1 for Addition");
                    System.out.println("2 for subtraction");
                    System.out.println("3 for multiplication");
                    System.out.println("4 for division");
                    System.out.println("5 exit");
                    
                    int choice = scan.nextInt();
                    
                     if (choice == 5) {
                    System.out.println("Thank you");
                    break;
                }
                    
                    if (choice == 1){
                         System.out.println("Add a Number");
                         
                         System.out.print("Enter 1st number: ");
                         int num1 = scan.nextInt();
                     
                         System.out.print("Enter 2nd number: ");
                         int num2 = scan.nextInt();
                         
                         int sum = num1 + num2;
                         System.out.println(sum);
                         
                    }else if (choice == 2){
                         System.out.println("Subtract a Number");
                         System.out.println("Enter 1st Number ");
                         int num1 = scan.nextInt();
                         
                          System.out.print("Enter 2nd number: ");
                         int num2 = scan.nextInt();
                         
                         int sum = num1 - num2;
                         System.out.println(sum);
            
                    }else if (choice == 3){
                        System.out.println("Multiply a Number");
                         System.out.println("Enter 1st Number ");
                         int num1 = scan.nextInt();
                         
                          System.out.print("Enter 2nd number: ");
                         int num2 = scan.nextInt();
                         
                         int sum = num1 * num2;
                         System.out.println(sum);
                        
                    }else if (choice == 4){
                        System.out.println("Divide a Number");
                         System.out.println("Enter 1st Number ");
                         double num1 = scan.nextInt();
                         
                          System.out.print("Enter 2nd number: ");
                         double num2 = scan.nextInt();
                         
                         double sum = num1 / num2;
                         System.out.println(sum);
                        
                    }else{
                        System.out.println("thank you");
                    }
                   
                    break;
                    
                    
                 default:
                    System.out.println("Wrong Password");
          
        }
          
        }else{
            System.out.println("Username not found");
        }
      
         
        }while(true);
        
    }
    
}
