package lab01;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        int[][] sumMat = new int[rows][cols];
        
        // Input Matrix 1
        System.out.println("Enter data for Matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                mat1[i][j] = sc.nextInt();
            }
        }
        
        // Input Matrix 2
        System.out.println("Enter data for Matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                mat2[i][j] = sc.nextInt();
                // Perform addition while reading input to optimize
                sumMat[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        
        // Display the result
        System.out.println("Resultant Matrix after addition:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sumMat[i][j] + "\t");
            }
            System.out.println();
        }
        
        sc.close();
    }
}