package Lab1;

// take array of Strings as input
// find the combined length of those strings

import java.util.Scanner;

public class Strings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emailId = sc.next();

        int start_idx = 0;
        int end_idx = emailId.indexOf('@');
        System.out.println(end_idx);

        String username = emailId.substring(start_idx, end_idx);
        System.out.println(username);
        
    }
}