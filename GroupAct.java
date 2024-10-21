import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter num1 ");
		double num1 = sc.nextDouble();
		System.out.println("Enter num2 ");
		double num2 = sc.nextDouble();
		System.out.println("----Select an Operations----");
		System.out.println("1 for Addition 2 for Subtraction 3 for Multiplication 4 for Division");
		
		char Operator = sc.next().charAt(0);
		switch (Operator){
			case '1':
			     Add(num1, num2);
			     break;
			case '2':
			     Subtract(num1, num2);
			     break;
		    case '3':
		         Multiply(num1, num2);
		         break;
		    case '4':
		    Divide(num1, num2);
		         break;
		    default:
		    System.out.println("Input a number");
			
			}
	}
	public static void Add(double num1, double num2){
		double result = num1 + num2;
		System.out.println(result);
		
		}
	public static void Subtract(double num1, double num2){
		double result = num1 - num2;
		System.out.println(result);
		}
	public static void Multiply(double num1, double num2){
		double result = num1 * num2;
		System.out.println(result);
		}
	public static void Divide(double num1, double num2){
		double result = num1 / num2;
		System.out.println(result);
		}
}