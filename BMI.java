import java.lang.Math;
import java.util.Scanner;

public class BMI {
    private static double convertToKilograms(int pounds){
        double kilogramRatio = 0.45359237;
        return(pounds*kilogramRatio);
    }
    private static double heightToMeters(int feet, int inches){
        double inchToCentimeterRatio = 2.54;
        double feetInch = 12;
        double inInches = (inches + (feet*feetInch));
        double heightCM = (inInches*inchToCentimeterRatio);
        return(heightCM/100.0);
    }
    public static String calculateBMI(int pounds, int feet, int inches){
        double kilograms = convertToKilograms(pounds);
        double heightInMeters = heightToMeters(feet, inches);
        double bmi = kilograms/Math.pow(heightInMeters,2);
        // round to one decimal place
        bmi = Math.round(bmi*10.0)/10.0;
        String weightStatus = "";
        if(bmi<18.5){
            weightStatus = "Underweight";
        } else if (bmi>=18.5 && bmi<=24.9) {
            weightStatus = "Normal or Healthy weight";
        } else if (bmi>=25.0 && bmi <=29.9) {
            weightStatus = "Overweight";
        } else{
            weightStatus = "Obese";
        }
        return(weightStatus);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = input.nextLine();
        System.out.print("Enter your weight in pounds: ");
        String poundsStr = input.nextLine();
        int pounds = Integer.parseInt(poundsStr);
        System.out.println("Enter your height in feet and inches: ");
        int feet = input.nextInt();
        int inches = input.nextInt();
        input.nextLine();
        String weightStatus = calculateBMI(pounds,feet,inches);
        System.out.println(weightStatus);
    }
}
