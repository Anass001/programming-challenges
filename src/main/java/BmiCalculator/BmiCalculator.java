package BmiCalculator;

import java.util.Objects;
import java.util.Scanner;

public class BmiCalculator {

    private float height;
    private float weight;
    private float bmi;

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float calculate() {
        assert height > 0;
        assert weight > 0;
        return calculate(height, weight);
    }

    public float calculate(float height, float weight) {
        bmi = weight / (float) Math.pow(height / 100, 2);
        return bmi;
    }

    public String categorize() {
        if (bmi == 0)
            return categorize(calculate(height, weight));
        return categorize(bmi);
    }

    public String categorize(float bmi) {
        if (bmi >= 30)
            return "Obese";
        else if (bmi >= 25)
            return "Overweight";
        else if (bmi >= 18.5)
            return "Normal";
        else
            return "Underweight";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BmiCalculator bmiCalculator = new BmiCalculator();
        System.out.println("Calculate your body mass index\n");
        System.out.println("Enter your height (in centimeters):");
        bmiCalculator.setHeight(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter your weight (in kilograms):");
        bmiCalculator.setWeight(Float.parseFloat(scanner.nextLine()));
        System.out.printf("Your body mass index is: %.2f\n", bmiCalculator.calculate());
        System.out.printf("Your BMI category is: %s\n", bmiCalculator.categorize());
    }
}
