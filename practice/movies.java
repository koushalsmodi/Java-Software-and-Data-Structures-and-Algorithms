import java.util.*;


//https://www.javatpoint.com/bucket-sort-in-java
public class movies
{
    //user-defined method to sort array
    public static List<Movie> binSort(List<Movie> array, int bucketSize)
    {
//creating a list of buckets for storing lists
        List<Movie>[] buckets = new List[bucketSize];
// Linked list with each bucket array index
// as there may be hash collision
        for(int i = 0; i < bucketSize; i++)
        {
            buckets[i] = new LinkedList<>();
        }
//calculate the hash and assigns elements to the proper bucket
        for(Movie num : array)
        {
            buckets[hash(num, bucketSize)].add(num);
        }
//iterate over the buckets and sorts the elements
        for(List<Movie> bucket : buckets)
        {
//sorts the bucket
            Collections.sort(bucket);
        }
        int index = 0;
//gather the buckets after sorting
        for(List<Movie> bucket : buckets)
        {
            for(Movie num : bucket)
            {
                array.set(index++, num);
            }
        }
        return array;
    }
    //distributing elements
    private static int hash(Movie num, int bucketSize)
    {
        return (int) (num.rating/bucketSize);
    }
    public static void main(String args[])
    {
//array to be sort

        //System.out.println("Unsorted Array: " + Arrays.toString(array));
        long curTime = System.currentTimeMillis();
//calling the user-defined method to sort the array
        //binSort(array, 10);
        System.out.printf("Time taken: ");
        System.out.println(System.currentTimeMillis() - curTime + "ms");


        //System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
