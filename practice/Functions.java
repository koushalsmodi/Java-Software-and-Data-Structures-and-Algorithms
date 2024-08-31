// make a function to multiply 2 numbers and return the product
import java.util.*;


public class Functions{
    public static int factorial(int a){
        if (a<=1){
            return 1;
        }else{
            return a * factorial(a-1);
        }
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println(factorial(a));

        sc.close();


    }
}