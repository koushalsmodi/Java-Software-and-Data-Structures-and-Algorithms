import java.util.List;

public class BubbleSort {

    public static void bubbleSort(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Long temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;

                }
            }
            if (!swapped) {
                break;
            }
        }

    }
    public static void printTop5(List<Long> list){
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int count = Math.min(5, list.size());
        
        for (int i  = list.size()-1; i >= list.size()-count; i--){
            System.out.println(list.get(i));
        }
    }

}
