public class BMICalculator {
    public static void main(String[] args) {
        
        double weight = 45; 
        double height = 1.67;

        double bmi = weight / (height * height);

        System.out.println("Your BMI is: " + bmi);
        if (bmi < 18.5) {
            System.out.println("Interpretation: Underweight");
        } else if (bmi > 18.5 && bmi < 25.0) {
            System.out.println("Interpretation: Normal");
        } else if (bmi > 25.0 && bmi < 30.0) {
            System.out.println("Interpretation: Overweight");
        } else {
            System.out.println("Interpretation: Obese");
        }
    }
}
