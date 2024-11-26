import java.util.Scanner;

public class StudentListJava {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String[] students = {"John", "Alice", "Bob", "Eve"};
     int[] scores = {85, 92, 76, 88};
     
        System.out.println("Student List: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(students[i] + "- " + scores[i]);
            
        }
        System.out.println("Enter the name of the student to update the score: ");
        String name = sc.nextLine();
        
        for (int i = 0; i < scores.length; i++) {
            if(students[i].equalsIgnoreCase(name)){
                System.out.println("Enter the new score " + name + ": ");
                scores[i] = sc.nextInt();
                break;
            }
        }
        System.out.println("Updated Student List: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(students[i] + "- "+ scores[i]);
            
        } 
    }   
}
