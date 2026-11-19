
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n================================");
            System.out.println("       JAVA CALCULATOR");
            System.out.println("================================");

            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. View History");
            System.out.println("7. Clear History");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            if (choice == 8) {
                System.out.println("Thank you for using Calculator!");
                break;
            }

            if (choice == 6) {
                System.out.println("\nCalculation History:");

                if (history.isEmpty()) {
                    System.out.println("No calculations available.");
                } else {
                    for (String item : history) {
                        System.out.println(item);
                    }
                }
                continue;
            }

            if (choice == 7) {
                history.clear();
                System.out.println("History cleared successfully!");
                continue;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            double result = 0;
            String operator = "";

            switch (choice) {

                case 1:
                    result = num1 + num2;
                    operator = "+";
                    break;

                case 2:
                    result = num1 - num2;
                    operator = "-";
                    break;

                case 3:
                    result = num1 * num2;
                    operator = "*";
                    break;

                case 4:
                    operator = "/";
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed!");
                        continue;
                    }
                    result = num1 / num2;
                    break;

                case 5:
                    operator = "%";
                    if (num2 == 0) {
                        System.out.println("Error: Modulus by zero is not allowed!");
                        continue;
                    }
                    result = num1 % num2;
                    break;
            }

            String calculation = num1 + " " + operator
                    + " " + num2 + " = " + result;

            System.out.println("\nResult: " + result);

            history.add(calculation);
        }

        sc.close();
    }
}
