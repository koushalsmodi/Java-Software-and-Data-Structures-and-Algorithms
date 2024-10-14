public class summing {
    // Write a recursive method to perform binary search on a sorted array.

    public static int sumNatural(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNatural(n - 1);
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        System.out.println(sumNatural(a));

    }
}
