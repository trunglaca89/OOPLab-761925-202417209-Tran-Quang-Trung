package lab01;

import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        // Display menu for equation selection
        String menu = "Select the type of equation to solve:\n" +
                      "1. First-degree equation with one variable (ax + b = 0)\n" +
                      "2. System of first-degree equations with two variables\n" +
                      "3. Second-degree equation with one variable (ax^2 + bx + c = 0)";
        
        String choice = JOptionPane.showInputDialog(null, menu, "Equation Solver", JOptionPane.QUESTION_MESSAGE);

        // Routing to specific solvers based on user choice
        if (choice == null) {
            System.exit(0);
        } else if (choice.equals("1")) {
            solveLinear();
        } else if (choice.equals("2")) {
            solveSystem();
        } else if (choice.equals("3")) {
            solveQuadratic();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0); 
    }

    // Task 1: Solve ax + b = 0 
    static void solveLinear() {
        // Input coefficients [cite: 315]
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input coefficient a:")); // 
        double b = Double.parseDouble(JOptionPane.showInputDialog("Input coefficient b:"));

        // Handle the case where a = 0 
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.");
            }
        } else {
            // Standard solution: x = -b/a 
            JOptionPane.showMessageDialog(null, "The solution is x = " + (-b / a));
        }
    }

    // Task 2: Solve system of linear equations with 2 variables 
    static void solveSystem() {
        // Input coefficients for the system 
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Input a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Input a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Input b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Input a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Input a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Input b2:"));

        // Calculate determinants 
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        // Check for unique, infinite, or no solution 
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Unique solution: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.");
            }
        }
    }

    // Task 3: Solve quadratic equation ax^2 + bx + c = 0 
    static void solveQuadratic() {
        // Input coefficients a, b, c
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input coefficient a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Input coefficient b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Input coefficient c:"));

        // Handle case where a = 0 (becomes a linear equation) 
        if (a == 0) {
            if (b == 0) {
                if (c == 0) JOptionPane.showMessageDialog(null, "Infinitely many solutions.");
                else JOptionPane.showMessageDialog(null, "No solution.");
            } else {
                JOptionPane.showMessageDialog(null, "Linear solution: x = " + (-c / b));
            }
        } else {
            // Use the discriminant Delta 
            double delta = b * b - 4 * a * c;
            
            if (delta > 0) {
                // Two distinct real roots
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has two distinct roots:\nx1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                // One double root 
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has a double root: x = " + x);
            } else {
                // No real roots
                JOptionPane.showMessageDialog(null, "The equation has no real roots.");
            }
        }
    }
}