// take a matrix as input from the user
// search for a given number x
// and print the (i,j)

import java.util.*;

public class TwoDArrays{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j=  0; j < columns; j++){
                numbers[i][j] = sc.nextInt();
            }
        }
        int user = sc.nextInt();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (numbers[i][j] == user){
                    System.out.println("row is: " + i + " column is: " + j);
                }
            }
        }

    }
}