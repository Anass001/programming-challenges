package SortingAlgorithms;

import java.io.IOException;

public class SortingAlgorithms {

    public static void bubble(int[] list) {
        ListDrawer drawer = ListDrawer.create();
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
            try {
                drawer.drawList(list);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        drawer.endTerminal();
    }

    public static void insertion(int[] list) {
        int j;
        for (int i = 1; i < list.length; i++) {
            int tmp = list[i];
            for (j = i - 1; j >= 0 && list[j] > tmp; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = tmp;
        }
    }

    public static void selection(int[] list) {
        int min;
        for (int i = 0; i < list.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = list[min];
                list[min] = list[i];
                list[i] = tmp;
            }
        }
    }

    public static void print(int[] list) {
        for (int i : list) {
            System.out.println(i);
        }
    }



    public static void main(String[] args) {
        int[] list = {4, 3, 2, 10, 12, 1, 5, 6};
        SortingAlgorithms.bubble(list);
        SortingAlgorithms.print(list);
    }
}