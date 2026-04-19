package lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        double sum = 0;
        
        // Input each element and calculate sum simultaneously
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Display the results
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average: " + (sum / n));
        
        sc.close();
    }
}