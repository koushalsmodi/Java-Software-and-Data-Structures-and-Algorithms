/*
 * *****
 * *****
 * *****
 * *****
 */

public class Loops{
    public static void main(String[] args){
        int n = 4;
        int m = 5;
        for (int row = 1; row <= n; row++){
            for (int col = 1; col <= m; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}