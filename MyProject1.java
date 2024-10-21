package Try;
import java.util.Scanner;
public class Covid {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String retry;
do{
    System.out.println("Do you have a Fever?: (yes/no)");
    String fever = sc.nextLine();
    System.out.println("Do you have a Cough?: (yes/no)");
    String cough = sc.nextLine();
    System.out.println("Do you have difficulty in Breathing?: (yes/no)");
    String breathing = sc.nextLine();
           
if(fever.equals("yes")) {
    System.out.println("You may have Covid 19 symptoms. Please consult a healthcare ");
}else if (cough.equals("yes")){
    System.out.println("You may have Covid 19 symptoms. Please consult a healthcare ");
}else if(breathing.equals("yes")){
    System.out.println("You may have Covid 19 symptoms. Please consult a healthcare ");
}else {
    System.out.println("You do not exhibit significant Covid 19 symtoms. Stay Safe ");
}
    System.out.println("Do you want to check symptoms again? ");
    retry = sc.nextLine();
    }while(retry.equalsIgnoreCase("yes")); 
  }
}
