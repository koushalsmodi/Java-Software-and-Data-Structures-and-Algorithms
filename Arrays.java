// take an array of numbers as input and check if it is an array sorted in ascending order
import java.util.*;

public class Arrays{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = sc.nextInt();
        }

        boolean isAscending = true;

        for (int i = 0; i < numbers.length-1; i++){
            if (numbers[i] < numbers[i+1]){
                isAscending = true;
            }
            else{
                isAscending = false;
            }
            
        }
        if (isAscending){
            System.out.println("sorted array");
        }
        else{
            System.out.println("Unsorted");
        }

    }
}