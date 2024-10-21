package charat.java;

import java.util.Scanner;

public class CharAtJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Lab Exercise");
        System.out.println("Enter a Character");
        char input = sc.next().charAt(2);
        
        if ((input >= 'a' && input <= 'z' || input >= 'A' && input <= 'Z')){
            System.out.println(input + " is a Letter ");
        }else if ((input >= '0' && input <= '9')){
            System.out.println(input + " is a Digit ");
        }else{
            System.out.println(input + " is not a Letter or Digit ");
        }
        
    }
    
}
