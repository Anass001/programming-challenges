import java.io.IOException;

public class SortingAlgorithms {

    public static void bubble(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
    }

    //needs optimizing
    public static void insertion(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] < list[j]) {
                    for (int k = i; k > j; k--) {
                        int tmp = list[k];
                        list[k] = list[k - 1];
                        list[k - 1] = tmp;
                    }
                    break;
                }
            }
        }
    }

    public static void selection(int[] list) {

    }

    public static void print(int[] list) {
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] list = {4, 3, 2, 10, 12, 1, 5, 6};
        SortingAlgorithms.insertion(list);
        SortingAlgorithms.print(list);

    }
}