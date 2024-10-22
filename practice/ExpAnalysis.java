package ExperimentalAnalysis;

// Perform an experimental analysis to test the hypothesis that Java's Array.sort method runs in 
import java.util.Random;
import java.util.Arrays;
public class ExpAnalysis {

    public static void main(String[] args) {

        Random random = new Random();
        double[] x = random.doubles(1000000, 10, 10000).toArray();

        long startTime = System.nanoTime(); // record the starting time

        /* (run the algorithm) */
        Arrays.sort(x);

        long endTime = System.nanoTime(); // record the ending time

        long elapsed = endTime - startTime; // compute the elapsed time
        System.out.println(elapsed);

    }

}
