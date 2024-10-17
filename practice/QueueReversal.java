// reverseQueue() that reverses all the elements in a queue. Assume the
// queue is implemented using a linked list or an array
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class QueueReversal{

    public static void reverseQueue(Queue<Integer> queue){

        Stack<Integer> stack = new Stack<>();


        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }

    }

    public static void printQueue(Queue<Integer> queue){

        for (Integer num : queue){
            System.out.print(num);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("original queue");
        printQueue(queue);

        reverseQueue(queue);

        System.out.println("after reversal");
        printQueue(queue);
        
    }
}