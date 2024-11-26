public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] numbers = new int[4][5];
        
        
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = (int) (Math.random() * 10);
            }
        }


        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");          
            }
            System.out.println();  
    }
    }
}