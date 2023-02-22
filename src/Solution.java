import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

//        int[] arr = {-2, 8, -9, 2, 5};
        int[] arr = {12, -2, 6, 0, 7, 9, 12};

//        insertionSort(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1);
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
}
