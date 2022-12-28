package Zadania.Zadanko_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class s20927{
    public static void main(String[] args) throws IOException{
        //3 6 12 4 7 19 20 20 9 11 : 5 70
        //1 1 2 2 1 1 1 : 5 7
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        //String[] tokens = scanner.nextLine().split(" ");
        int[] numbers = new int [100];
        int j = 0;
        while(scanner.hasNextInt()) {
            numbers[j++] = scanner.nextInt();
        }

        int maxLength = 0;
        int maxSum = 0;
        int sum = 0;
        int length = 0;

        // brak pętli w pętli więc mamy złóżoność liniową

        for(int i = 0; i < numbers.length - 1; i++){
            if(numbers[i] <= numbers[i + 1]){
                sum += numbers[i];
                length++;
            }else{
                sum += numbers[i];
                length++;
                if(sum > maxSum){
                    maxSum = sum;
                }

                if(length > maxLength){
                    maxLength = length;
                }

                sum = 0;
                length = 0;
            }
        }
        System.out.println(maxLength + " " + maxSum);
    }
}
