import java.io.*;
import java.util.*;

public class Solution {

    //Сортировка выбором
    static void sort_selection(int a[]){
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    min_index = j;
                }
            }

            if (i != min_index) {
                int tmp = a[i];
                a[i] = a[min_index];
                a[min_index] = tmp;
            }
        }
    }

    //Сортировка пузырьком
    static void bubble_sort(int[] a) {

        for(int i = 1; i < a.length; i++){
            for(int j = 0; j < a.length-i; j++){
                if(a[j] > a[j+1]){
                    int k = a[j];
                    a[j] = a[j+1];
                    a[j+1] = k;
                }
            }
        }
    }

    //Сортировка пузырьком 2
    static void bubble_sort2(int[] a) {

        for(int i = a.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    int k = a[j];
                    a[j] = a[j+1];
                    a[j+1] = k;
                }
            }
        }
    }

    //Быстрая сортировка
    static void quick_sort(int[] array, int first1, int last1) {
        if (array.length == 0)
            return;

        int first = first1;
        int last = last1;

        if (first >= last)
            return;

        // выбрать опорный элемент
        int middle = (first + last) / 2;

        while (first < last){
            while ((first < middle) && (array[first] <= array[middle])){
                first++;
            }
            while ((last > middle) && (array[last] >= array[middle])){
                last--;
            }

            if(first < last){
                int temp = array[first];
                array[first] = array[last];
                array[last] = temp;

                // И меняем индекс опорного элемента
                if(first == middle){
                    middle = last;
                }else {
                    if(last == middle){
                        middle = first;
                    }
                }
            }

        }

        quick_sort(array, first1, middle);
        quick_sort(array, middle+1, last1);

    }

    // Сортировка вставками
    static int[] insert_sort(int[] a) {
        int j, temp;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];

            for (j = i - 1; j >= 0 && a[j] > temp ; j--) {
                a[j+1] = a[j];
            }

            a[j+1] = temp;
        }

        return a;
    }

    // Сортировка слиянием
    static int[] merge_sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            array = merge_sort(array, start, middle);
            array = merge_sort(array, middle + 1, end);

            //слияние двух массивов
            array = merge(array, start, middle, end);
        }
        return array;
    }

    static int[] merge(int array[], int start, int middle, int end){
        int a = start;
        int b = middle + 1;

        int result[] = new int[end - start + 1];

        for (int i = 0; i < end - start + 1; i++){
            if ((a <= middle) && (b <= end)) {
                if (array[a] > array[b]){
                    result[i] = array[b];
                    b++;
                }else {
                    result[i] = array[a];
                    a++;
                }
            }else{
                if (a > middle){
                    result[i] = array[b];
                    b++;
                }
                else{
                    result[i] = array[a];
                    a++;
                }
            }
        }
        System.arraycopy(result,0, array, start,end - start + 1);
        return array;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        //sort_selection(x);
        //bubble_sort(x);
        //bubble_sort2(x);
        //quick_sort(x,0,n-1);
        //x = insert_sort(x);
        x = merge_sort(x,0,x.length-1);

        for (int i :x){
            System.out.print(i + " ");
        }

        scanner.close();
    }
}

/*

8
6 5 3 1 8 7 2 4

9
6 5 1 3 8 4 7 9 2

10
1 9 5 0 7 2 9 4 8 10

*/
