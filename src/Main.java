import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        final int maxMonth = 12;
        System.out.println("\nMANUAL SUCCESSOR DATE CALCULATOR\n\n\n");
        System.out.println("Please enter the day:");
        int day = sc.nextInt();
        System.out.println("Please enter the month:");
        int month = sc.nextInt();
        System.out.println("Please enter the year:");
        int year = sc.nextInt();
        int maxDays, successorDay = day, successorMonth = month, successorYear = year;

        switch(month) {
            case 1, 3, 5, 7, 8, 10, 12:
                maxDays = 31;
                run(maxDays, maxMonth, day, month, year, successorDay, successorMonth, successorYear);
                break;
            case 9, 4, 6, 11:
                maxDays = 30;
                run(maxDays, maxMonth, day, month, year, successorDay, successorMonth, successorYear);
                break;
            case 2:
                if (year % 4 == 0) {
                    maxDays = 29;
                    run(maxDays, maxMonth, day, month, year, successorDay, successorMonth, successorYear);
                } else {
                    maxDays = 28;
                    run(maxDays, maxMonth, day, month, year, successorDay, successorMonth, successorYear);
                }
                break;
            default:
                System.out.println("Invalid month");
                break;
        }
    }

    static int[] successor(int maxDays, int maxMonth, int day, int month, int year, int successorDay, int successorMonth, int successorYear)
    {
        if(day < maxDays)
        {
            successorDay = ++day;
        }
        else if(day == maxDays && month == maxMonth){
            successorDay = 1;
            successorMonth = 1;
            successorYear = ++year;
        }
        else if (day == maxDays && month != maxMonth){
            successorDay = 1;
            successorMonth = ++month;
        }
        else{
            System.out.println("Invalid Day");
        }
        return new int[] {successorDay, successorMonth, successorYear};
    }

    static void run(int maxDays, int maxMonth, int day, int month, int year, int successorDay, int successorMonth, int successorYear)
    {
        int[] result;
        if (day <= maxDays)
        {
            result = successor(maxDays,maxMonth,day,month,year,successorDay,successorMonth,successorYear);
            successorDay = result[0];
            successorMonth = result[1];
            successorYear = result[2];
            System.out.println("The successor date is " + successorDay + "/" + successorMonth + "/" + successorYear);
        }
        else{
            System.out.println("Invalid Day");
        }
    }
}