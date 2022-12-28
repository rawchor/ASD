package Zadania.Zadanko_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ASD1{
    public static void main(String[] args) throws IOException{
        //3 6 12 4 7 19 20 20 9 11 : 5 70
        //1 1 2 2 1 1 1 : 5 7
        //1 1 7 3 2 0 0 4 5 5 6 2 1 : 6 20
        //8 4 2 3 2 : 3 14
        //65 87 47 5 12 74 25 32 78 44 40 77 85 4 29 57 55 79 31 63 84 66 62 41 52 36 82 86 6 98 63 65 14 57 75 14 74 15 41 88 27 75 6 78 98 78 22 77 68 74 92 47 30 44 40 52 70 66 17 60 47 97 34 37 23 69 56 57 3 45 7 76 18 35 24 73 47 77 1 84 92 54 18 98 84 36 66 71 92 13 77 28 75 24 46 67 4 63 82 1 : 253
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        int num1;
        int num2;

        int maxLength = 0;
        int maxSum = 0;
        int sum = 0;
        int length = 0;

        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        while(scanner.hasNextInt()) {
            //System.out.print(num1 + ", " + num2 + ", ");
            if (num1 <= num2) {
                sum += num1;
                length++;

                num1 = num2;
                num2 = scanner.nextInt();
            } else {
                sum += num1;
                length++;
                if (sum > maxSum) {
                    maxSum = sum;
                }

                if (length > maxLength) {
                    maxLength = length;
                }

                sum = 0;
                length = 0;
                num1 = num2;
                num2 = scanner.nextInt();
            }
        }
        //System.out.println("\n" + maxLength + " " + maxSum);
        System.out.println(maxLength + " " + maxSum);
    }
}