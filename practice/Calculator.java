import java.util.*;

import javax.management.openmbean.ArrayType;

public class Calculator{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String operation = sc.next();

        switch (operation){

            case "+":
            System.out.println(a+b);
            break;

            case "-":
            System.out.println(a-b);
            break;

            case "*":
            System.out.println(a*b);
            break;

            case "/":{
                if (b == 0){
                    throw new ArithmeticException("cannot divide by 0 error");
                }
                System.out.println(a/b);
                break;

            }
            
            case "%":{
                //if (b == 0){
                    //throw new ArithmeticException("zero divison error");
                //}
                System.out.println(a%b);
                break;
            }
            
            

            default:
            throw new IllegalArgumentException("illegal and invalid argument");

        }

    }
}