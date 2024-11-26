public class LargestSmallestNumber {
	public static void main(String[] args) {
		int[] numbers = {34, 56, 23, 89, 12, 78, 55, 21, 90, 11};
		int largest = numbers [0];
		int smallest = numbers [0];
		
		for (int number : numbers){
		    if (number < smallest){
		    	smallest = number;
		    	}
		    	
		    if (number > largest){
		    	largest = number;
		    	}
		}
		
		System.out.println("The largest number is: " + largest);
		System.out.println("The smallest number is: " + smallest);
	}
}