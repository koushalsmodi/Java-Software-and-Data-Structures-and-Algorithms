import java.util.List;

public class SelectionSort {

    public static void selectionSort(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            
            Long temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
            
        }
    
    }

    public static void printTop5(List<Long> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int count = Math.min(5, list.size());

        for (int i = list.size() - 1; i >= list.size() - count; i--) {
            System.out.println(list.get(i));
        }
    }

}
