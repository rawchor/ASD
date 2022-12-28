package Zadania.Zadanko_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class s20927v2{
    public static void main(String[] args) throws IOException{
        //3 6 12 4 7 19 20 20 9 11 : 5 70
        //1 1 2 2 1 1 1 : 5 7
        //1 1 7 3 2 0 0 4 5 5 6 2 1 : 6 20
        //8 4 2 3 2 : 3 14
        //65 87 47 5 12 74 25 32 78 44 40 77 85 4 29 57 55 79 31 63 84 66 62 41 52 36 82 86 6 98 63 65 14 57 75 14 74 15 41 88 27 75 6 78 98 78 22 77 68 74 92 47 30 44 40 52 70 66 17 60 47 97 34 37 23 69 56 57 3 45 7 76 18 35 24 73 47 77 1 84 92 54 18 98 84 36 66 71 92 13 77 28 75 24 46 67 4 63 82 1 : 253
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        Scanner scanner2 = new Scanner(new FileInputStream(args[0]));
        int num1;
        int num2;

        int maxLength1 = 0;
        int maxSum1 = 0;
        int maxLength2 = 0;
        int maxSum2 = 0;

        int sum1 = 0;
        int length1 = 0;
        int sum2 = 0;
        int length2 = 0;

        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        while(scanner.hasNextInt()) {
            //System.out.print(num1 + ", " + num2 + ", ");
            if (num1 <= num2) {
                sum1 += num1;
                length1++;

                num1 = num2;
                num2 = scanner.nextInt();
            } else {
                sum1 += num1;
                length1++;
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                }

                if (length1 > maxLength1) {
                    maxLength1 = length1;
                }

                sum1 = 0;
                length1 = 0;
                num1 = num2;
                num2 = scanner.nextInt();
            }
        }


        int num3;
        int num4;
        num3 = scanner2.nextInt();
        num4 = scanner2.nextInt();
        while(scanner2.hasNextInt()) {
            //System.out.print(num3 + ", " + num4 + ", ");
            if (num3 >= num4) {
                sum2 += num3;
                length2++;

                num3 = num4;
                num4 = scanner2.nextInt();
            } else {
                sum2 += num3;
                length2++;
                if (sum2 > maxSum2) {
                    maxSum2 = sum2;
                }

                if (length2 > maxLength2) {
                    maxLength2 = length2;
                }

                sum2 = 0;
                length2 = 0;
                num3 = num4;
                num4 = scanner2.nextInt();
            }
        }

        if(maxLength1 > maxLength2){
            //System.out.println("\n" + maxLength1 + " " + maxSum1);
            System.out.println(maxLength1 + " " + maxSum1);
        } else {
            //System.out.println("\n" + maxLength2 + " " + maxSum2);
            System.out.println(maxLength2 + " " + maxSum2);
        }
    }
}