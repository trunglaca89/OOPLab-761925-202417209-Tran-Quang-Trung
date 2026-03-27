package lab01;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int year;
        String month;

        // 1. Input and validate the year (non-negative integer)
        while (true) {
            System.out.print("Enter the year");
            if (keyboard.hasNextInt()) {
                year = keyboard.nextInt();
                if (year >= 0) break; 
            } else {
                keyboard.next(); // Clear invalid input
            }
            System.out.println("Invalid year. Please enter a non-negative integer!");
        }

        // 2. Input and validate the month
        int days = 0;
        while (days == 0) {
            System.out.print("Enter the month (Full name, abbreviation, or number): ");
            month = keyboard.next().toLowerCase(); // Convert to lowercase for uniform checking

            switch (month) {
                // Months with 31 days
                case "january": case "jan.": case "jan": case "1":
                case "march": case "mar.": case "mar": case "3":
                case "may": case "5":
                case "july": case "jul": case "7":
                case "august": case "aug.": case "aug": case "8":
                case "october": case "oct.": case "oct": case "10":
                case "december": case "dec.": case "dec": case "12":
                    days = 31;
                    break;
                
                // Months with 30 days
                case "april": case "apr.": case "apr": case "4":
                case "june": case "jun": case "6":
                case "september": case "sept.": case "sep": case "9":
                case "november": case "nov.": case "nov": case "11":
                    days = 30;
                    break;

                // February
                case "february": case "feb.": case "feb": case "2":
                    // Leap year check logic
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;

                default:
                    System.out.println("Invalid month format. Please try again!");
            }
        }

        // 3. Display the result
        System.out.println("Number of days: " + days);
        keyboard.close();
    }
}