// print a table of a number input by a user
import java.util.*;
public class Loops{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++){
            System.out.println(num*i);
        }
        sc.close();

    }
}