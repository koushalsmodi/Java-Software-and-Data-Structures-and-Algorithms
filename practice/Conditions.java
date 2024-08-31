// if num == 1 -> hello
// num == 2 -> namaste
// num == 3 -> bonjour


import java.util.*;

public class Conditions{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        switch(num){

            case 1:{
                System.out.println("Hello");
                break;

            }

            case 2: System.out.println("Namaste");
            break;

        
            

            case 3: {
                System.out.println("Bonjour");
                break;
            }
            default: System.out.println("Invalid button");

        }
    }
}