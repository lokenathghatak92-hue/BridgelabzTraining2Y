import java.util.Scanner;
public class BMI{
    public static String[][] calculateBMI(double[][] people) {
        String[][] result = new String[people.length][4];
        for (int i = 0; i < people.length; i++) {
            double weight = people[i][0];
            double height = people[i][1] / 100.0;
            if (height <= 0 || weight <= 0) {
                result[i][0] = String.valueOf(people[i][1]);
                result[i][1] = String.valueOf(weight);
                result[i][2] = "Invalid";
                result[i][3] = "Invalid input";
                continue;
            }
            double bmi = weight / (height * height);
            String status;

            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 25)
                status = "Normal";
            else if (bmi < 30)
                status = "Overweight";
            else
                status = "Obese";

            result[i][0] = String.valueOf(people[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }

        return result;
    }

    public static void display(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s%n",
                "Height(cm)", "Weight(kg)", "BMI", "Status");

        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s%n",
                    row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] people = new double[10][2];

        for (int i = 0; i < people.length; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            people[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            people[i][1] = sc.nextDouble();
        }

        display(calculateBMI(people));
        sc.close();
    }
}