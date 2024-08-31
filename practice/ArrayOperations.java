class Calculations {
    private int[] numbers;
    private int position;
    private int value;

    public Calculations(int[] numbers, int position, int value) {
        this.numbers = numbers;
        this.position = position;
        this.value = value;
    }

    public void insertArray(int[] numbers, int position, int value) {
        System.out.println("Before insertion: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        for (int i = numbers.length - 1; i > position; i--) {
            numbers[i] = numbers[i - 1];
        }
        numbers[position] = value;
        System.out.println("After insertion: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }

    public void deleteArray(int[] numbers, int index){
        for ( int  i =index; i < numbers.length-1; i++){
            numbers[i] = numbers[i+1];
        }
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}

public class ArrayOperations {
    public static void main(String[] args) {
        int[] numbers = { 11, 21, 31, 51, 51 };
        int position = 3;
        int value = 41;
        Calculations calc = new Calculations(numbers, 2, 41);
        calc.insertArray(numbers, position, value);
        int index = 2;
        System.out.println();
        System.out.println("deleting 31 now");
        calc.deleteArray(numbers, index);
        // calc.insertArray();
        // insert a new number 41 between 31 and 51 in the array

    }

}
