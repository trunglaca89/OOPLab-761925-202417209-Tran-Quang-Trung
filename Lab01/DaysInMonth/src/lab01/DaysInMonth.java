package lab01;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int year;
        String month;

        // 1. Nhap ve kiem tra nam (so khong am)
        while (true) {
            System.out.print("Nhập năm (vd: 1999): ");
            if (keyboard.hasNextInt()) {
                year = keyboard.nextInt();
                if (year >= 0) break; // 
            } else {
                keyboard.next(); //
            }
            System.out.println("Năm không hợp lệ. Vui lòng nhập lại số nguyên không âm!");
        }

        // 2. Nhap va kiem tra thang
        int days = 0;
        while (days == 0) {
            System.out.print("Nhập tháng (Tên, viết tắt hoặc số): ");
            month = keyboard.next().toLowerCase(); // Chuyen het ve chu thuong

            switch (month) {
                // Nhom cac thang co 31 ngày
                case "january": case "jan.": case "jan": case "1":
                case "march": case "mar.": case "mar": case "3":
                case "may": case "5":
                case "july": case "jul": case "7":
                case "august": case "aug.": case "aug": case "8":
                case "october": case "oct.": case "oct": case "10":
                case "december": case "dec.": case "dec": case "12":
                    days = 31;
                    break;
                
                // Nhom cac thang co 30 ngay
                case "april": case "apr.": case "apr": case "4":
                case "june": case "jun": case "6":
                case "september": case "sept.": case "sep": case "9":
                case "november": case "nov.": case "nov": case "11":
                    days = 30;
                    break;

                // Thang 2
                case "february": case "feb.": case "feb": case "2":
                    // Kiểm tra năm nhuận
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;

                default:
                    System.out.println("Tháng không hợp lệ. Vui lòng nhập lại!");
            }
        }

        // 3. In ket qua
        System.out.println("Số ngày trong tháng là: " + days);
        keyboard.close();
    }
}