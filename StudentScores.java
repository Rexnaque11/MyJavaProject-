public class StudentScores {
	public static void main(String[] args) {
		char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
		char[][] studentsAnswers = {
            {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
            {'D', 'B', 'A', 'B', 'C', 'A', 'C', 'E', 'E', 'A'}, 
            {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'}, 
            {'C', 'B', 'A', 'E', 'D', 'C', 'C', 'E', 'E', 'A'}, 
            {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
            {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'E', 'D'}, 
            {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        };
        
        for(int row = 0; row < studentsAnswers.length; row++){
        	int score = 0;
        	for(int col = 0; col < key.length; col++){
        		if(studentsAnswers[row][col] == key[col]){
        			score++;
        			}
        		
        		}
        		System.out.println("Student " + row + " score " + " :  " +score);
        	}
	}
}
