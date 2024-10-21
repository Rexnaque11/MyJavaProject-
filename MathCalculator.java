package Try;

import java.util.Scanner;

public class MathCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = "RexGwapo";
        int password = 0701;
        String typeUsername;
        int typePassword;

        do {
            System.out.print("Enter Username: ");
            typeUsername = scan.nextLine();

            if (typeUsername.equals(username)) {
                System.out.print("Enter Password: ");
                typePassword = scan.nextInt();
                
               
                scan.nextLine();

                switch (typePassword) {
                    case 0701:
                        System.out.println("------MATH CALCULATOR------");
                        System.out.println("Enter a Number for Operation:");
                        System.out.println("1 for Addition");
                        System.out.println("2 for Subtraction");
                        System.out.println("3 for Multiplication");
                        System.out.println("4 for Division");
                        System.out.println("5 for Exit");

                        int choice = scan.nextInt();

                        if (choice == 1) {
                            System.out.println("Add a Number:");
                            System.out.print("Enter 1st Number: ");
                            int num1 = scan.nextInt();
                            System.out.print("Enter 2nd Number: ");
                            int num2 = scan.nextInt();
                            int sum = num1 + num2;
                            System.out.println(sum);

                        } else if (choice == 2) {
                            System.out.println("Subtract a Number:");
                            System.out.print("Enter 1st Number: ");
                            int num1 = scan.nextInt();
                            System.out.print("Enter 2nd Number: ");
                            int num2 = scan.nextInt();
                            int sum = num1 - num2;
                            System.out.println(sum);

                        } else if (choice == 3) {
                            System.out.println("Multiply a Number:");
                            System.out.print("Enter 1st Number: ");
                            int num1 = scan.nextInt();
                            System.out.print("Enter 2nd Number: ");
                            int num2 = scan.nextInt();
                            int sum = num1 * num2;
                            System.out.println(sum);

                        } else if (choice == 4) {
                            System.out.println("Divide a Number:");
                            System.out.print("Enter 1st Number: ");
                            double num1 = scan.nextDouble();
                            System.out.print("Enter 2nd Number: ");
                            double num2 = scan.nextDouble();
                            double sum = num1 / num2;
                            System.out.println(sum);

                        } else {
                            System.out.println("Thank You!!");
                            break;
                        }
                        break;

                    default:
                        System.out.println("Wrong Password!");
                }
            } else {
                System.out.println("Username not Found!");
            }
        } while (true);
    }
}
