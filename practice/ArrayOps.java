class MyCalcs{

    public void insertArray(int[] numbers, int position, int value){
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println();
        for (int i = numbers.length-1; i > position; i--){
            numbers[i] = numbers[i-1];
        }
        numbers[position] = value;
        // numbers[numbers.length-1] = 0;
        System.out.println();
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }


    public void deleteArray(int[] numbers, int index){
        for (int i =index ; i < numbers.length-1; i++){
            numbers[i] = numbers[i+1];
        }
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

    }
}

public class ArrayOps{
    public static void main(String[] args){

        int[] numbers = {11, 21, 31, 51};
        //               0, 1, 2, 3
        // write a method to insert a number 41 between 31 and 51 in the array
        MyCalcs mc = new MyCalcs();
        // mc.insertArray(numbers, 3, 41);
        mc.deleteArray(numbers, 2);



        // write a method to delete the number 31 from the array


    }
}