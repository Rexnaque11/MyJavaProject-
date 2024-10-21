import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = "Apple";
		
		String secretWord = word;
		
		
		int max_attempts = 5;
	System.out.println("Welcome to the secret word game");
	System.out.println("Try to guess the secret word. You have "+ max_attempts + " attempts");
	
	int attempts = 0;
	
	while (attempts < max_attempts){
		System.out.print("Enter your guess: ");
		String guess = sc.nextLine();
		
		if (guess.equals(secretWord)){
			System.out.println("Congratulations You win the game. ");
			break;
			}else{
				if(guess.length() < secretWord.length() ){
					System.out.println("Too short ");		
				}else if (guess.length() > secretWord.length()){
					System.out.println("Too long");
					}else{
						System.out.println("Wrong Word, Try Again");
						
						
						}
				}
		
	
	
           attempts ++;
           System.out.println("Remaining Attempts" + (max_attempts - attempts));
           
	}	
	
	if(attempts == max_attempts){
		System.out.println("Sorry you don't have any attempts left. The secret word is " + word) ;
		}
		

		 
		
		
	}
}