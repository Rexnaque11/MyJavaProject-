import java.util.Scanner;
public class MathCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String username = "Rex";
        int password = 1430;

        System.out.println("Enter Username: ");
        String typeUsername = sc.nextLine();

        if(typeUsername.equals(username)){
            System.out.println("Enter Password");
            int typePassword = sc.nextInt();

            switch (typePassword) {
                case 1430:
                    
            System.out.println("----MATH CALCULATOR----");
            System.out.println("Enter a number for Computation");
            System.out.println("1. for Addition");
            System.out.println("2. for Subtraction");
            System.out.println("3. for Multiplicatiobn");
            System.out.println("4. for Division");
            System.out.println("5. for Exit");

            int choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Add Number ");
                System.out.println();
                System.out.println("Enter First Number: ");
                int num1 = sc.nextInt();
                System.out.println("Enter Second Number: ");
                int num2 = sc.nextInt();
                int sum = num1 + num2;
                System.out.println("Result is " + sum);

            }else if(choice == 2){
                System.out.println("Subtract Number ");
                System.out.println();
                System.out.println("Enter First Number: ");
                int num1 = sc.nextInt();
                System.out.println("Enter Second Number: ");
                int num2 = sc.nextInt();
                int sum = num1 - num2;
                System.out.println("Result is " + sum);
            }else if (choice == 3){
                System.out.println("Multiply Number ");
                System.out.println();
                System.out.println("Enter First Number: ");
                int num1 = sc.nextInt();
                System.out.println("Enter Second Number: ");
                int num2 = sc.nextInt();
                int sum = num1 * num2;
                System.out.println("Result is " + sum);
            }else if (choice == 4){
                System.out.println("Divide Number ");
                System.out.println();
                System.out.println("Enter First Number: ");
                int num1 = sc.nextInt();
                System.out.println("Enter Second Number: ");
                int num2 = sc.nextInt();
                int sum = num1 / num2;
                System.out.println("Result is " + sum);
            }else{
                System.out.println("Thank You");
            }
            break;
            default:
            System.out.println("Wrong Password");

            }

        }else{
            System.out.println("UserName Not Found");
        }

    }
    
}