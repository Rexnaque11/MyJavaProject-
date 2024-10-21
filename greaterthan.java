import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter First Number: ");
		double num1 = sc.nextDouble();
		System.out.print("Enter Second Number: ");
		double num2 = sc.nextDouble();
		
		if(num1 > num2){	
		System.out.println("The first number is greater than the second number ");
		}else if(num1 < num2){
		System.out.println("The second number is greater than the first number");
		}else if(num1 == num2){
		System.out.println("Both numbers are equals");
		}
	}
}