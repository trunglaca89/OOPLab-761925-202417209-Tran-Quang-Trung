package lab01;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = sc.nextInt();
        
        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        int[][] sumMat = new int[rows][cols];
        
        System.out.println("Nhập dữ liệu cho Ma trận 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                mat1[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Nhập dữ liệu cho Ma trận 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                mat2[i][j] = sc.nextInt();
                // Thực hiện cộng luôn khi nhập
                sumMat[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        
        System.out.println("Ma trận kết quả sau khi cộng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sumMat[i][j] + "\t");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
