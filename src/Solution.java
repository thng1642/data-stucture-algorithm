import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

//        int[] arr = {-2, 8, -9, 2, 5};
//        int[] arr = {12, -2, 6, 0, 7, 9, 12};
//        int[] arr = { 9, 3, 4, 5, 7, 0, 6 };
        int[] arr = {8, 4, 3, 1, 6, 7, 11, 9, 2, 10, 5};

//        insertionSort(arr, arr.length);
//        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    private static void insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {

            int j = i - 1, current = arr[i], iCurrent = i;
            while (iCurrent > 0) {
                if (current < arr[j]) {

                    arr[iCurrent] = arr[j];
                    iCurrent--;
                    j--;

                } else break;

            }
            arr[iCurrent] = current;
            System.out.println("Sorting: " + Arrays.toString(arr));
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {

        // data copy process
        int nL = mid - left + 1;
        int nR = right - mid;
        int Left[] = new int[nL], Right[] = new int[nR];

        for (int i = 0; i < nL; i++) {
            Left[i] = a[left + i];
        }

        for (int i = 0; i < nR; i++) {
            Right[i] = a[mid + 1 + i];
        }

        // Condition loop two pointers
        int iL = 0, iR = 0, k = left;

        while(nL > iL && nR > iR) {

            // compare Left ele and Right ele
            if (Left[iL] <= Right[iR]) {

                a[k] = Left[iL];
                iL++;
            } else {
                a[k] = Right[iR];
                iR++;
            }
            k++;
        }

        // Right or Left remain elements, not yet placed.
        while (iR < nR) {
            a[k] = Right[iR];
            iR++;k++;
        }
        while (iL < nL) {
            a[k] = Left[iL];
            iL++;k++;
        }
    }

    private static int partition(int[] a, int left, int right) {

        int pointer = right, i = left;
        boolean isRearrange = false;

        while (i < right) {

            if (a[i] >= a[right] && !isRearrange) {

                pointer = i;
                isRearrange = true;
            }
            else if (a[i] < a[right] && isRearrange) {
//                if (pointer != -1) {
                    // swapping
                    int tmp = a[pointer];
                    a[pointer] = a[i];
                    a[i] = tmp;
                    pointer++;
//                }
            }
            i++;
        }
        try {
            int tmp = a[pointer];
            a[pointer] = a[right];
            a[right] = tmp;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("Pivot: " + pointer);
        return pointer;
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = partition(a, left, right);
            quickSort(a, left, pivot - 1);
            quickSort(a, pivot + 1, right);
        }
    }
}
