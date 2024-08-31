import java.util.ArrayList;
import java.util.Collections;
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList <Integer> list1 = new ArrayList<>();
        // add elements
        list1.add(34);
        list1.add(2);
        list1.add(1);
        System.out.println(list1);

        // get elements
        int element0 = list1.get(0);
        System.out.println(element0);
        int element1 = list1.get(1);
        System.out.println(element1);
        int element2 = list1.get(2);
        System.out.println(element2);

        // add element in between
        list1.add(1, 1);
        System.out.println(list1);

        // set element
        list1.set(0, 5);
        System.out.println(list1);

        // delete element
        list1.remove(3);
        System.out.println(list1);

        // int size
        int size = list1.size();
        System.out.println(size);

        // iterate

        for (int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
        // sorting
        Collections.sort(list1);
        System.out.println(list1);
        
    }
    
}
