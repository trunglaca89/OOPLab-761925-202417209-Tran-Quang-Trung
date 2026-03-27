package lab01;

import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
        // Get the first input number 
        String strNum1 = JOptionPane.showInputDialog(null, 
            "Please input the first number: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        
        // Get the second input number 
        String strNum2 = JOptionPane.showInputDialog(null, 
            "Please input the second number: ", "Input", JOptionPane.INFORMATION_MESSAGE);

        // Convert the input strings to double values
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Perform arithmetic operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotientResult;

        // Check the divisor before performing division 
        if (num2 != 0) {
            quotientResult = String.valueOf(num1 / num2);
        } else {
            quotientResult = "Cannot divide by zero!";
        }

        // Prepare and display the final results 
        String result = "Sum: " + sum + "\n" +
                        "Difference: " + difference + "\n" +
                        "Product: " + product + "\n" +
                        "Quotient: " + quotientResult;

        JOptionPane.showMessageDialog(null, result, "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
        
        // Exit the application 
        System.exit(0); 
    }
}