import java.util.*;
// import java.util.stream.IntStream;
import java.io.*;

//https://www.javatpoint.com/bucket-sort-in-java
class BucketSortExample1 {
    private static int maxValue;

    // user-defined method to sort array
    private static void binSort(int[] array, int bucketSize) {
        // Find the maximum value in the input array first
        maxValue = array[0];
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // creating a list of buckets for storing lists
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[bucketSize];

        // Linked list with each bucket array index
        // as there may be hash collision
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }

        // calculate the hash and assigns elements to the proper bucket
        for (int num : array) {
            buckets[hash(num, bucketSize)].add(num);
        }

        // iterate over the buckets and sorts the elements
        for (List<Integer> bucket : buckets) {
            // sorts the bucket
            Collections.sort(bucket);
        }

        int index = 0;
        // gather the buckets after sorting
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }

    // distributing elements
    private static <T> int hash(int num, int bucketSize) {
        if (maxValue == 0) {
            return 0;
        }
        return Math.min(bucketSize - 1, (num * bucketSize) / (maxValue + 1));
    }

    public static void main(String args[]) {

        String filePath = "integers.txt";
        ArrayList<Integer> values = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int value = Integer.parseInt(line);
                    values.add(value);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Convert ArrayList to array
        int[] array = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        // array to be sort
        // int[] array = IntStream.generate(() -> new
        // Random().nextInt(10)).limit(1000000).toArray();
        // int[] array2 = { 64, 34, 25, 12, 22, 11, 90 };
        // System.out.println("Unsorted Array: " + Arrays.toString(array));
        long curTime = System.currentTimeMillis();
        int bucketSize = array.length;

        // calling the user-defined method to sort the array
        binSort(array, bucketSize);
        System.out.printf("Time taken: ");
        System.out.println(System.currentTimeMillis() - curTime + "ms");

        // System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
