package oop.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray<T extends Comparable<T>> {

    private T[] elements;
    private int length;

    public MyArray(T[] elements, int length) {

        this.elements = elements;
        this.length = length;
    }

    public MyArray() {

        this.elements = null;
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }

    public T[] getElements() {
        return this.elements;
    }

    public void printArray() {
        System.out.println("Data: " + Arrays.toString(this.elements));
    }

    public void insertionSort(boolean isAscending) {
        for (int i = 1; i < this.length; i++) {

            int j = i - 1, iCurrent = i;
            T current = this.elements[i];

            while (iCurrent > 0) {

                if (isAscending) {
                    if (current.compareTo(this.elements[j]) < 0) {

                        this.elements[iCurrent] = this.elements[j];
                        iCurrent--;
                        j--;

                    } else break;
                }
                else {
                    if (current.compareTo(this.elements[j]) > 0) {

                        this.elements[iCurrent] = this.elements[j];
                        iCurrent--;
                        j--;

                    } else break;
                }

            }

            this.elements[iCurrent] = current;
        }
    }

    public void mergeSort(int left, int right) {

        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {

        // data copy process
        int nL = mid - left + 1;
        int nR = right - mid;
        List<T> Left = new ArrayList<>(nL);
        List<T> Right = new ArrayList<>(nR);
//        int Left[] = new int[nL], Right[] = new int[nR];

        for (int i = 0; i < nL; i++) {
            Left.add(i, this.elements[left + i]);
        }

        for (int i = 0; i < nR; i++) {
            Right.add(i, this.elements[mid + 1 + i]);
        }

        // Condition loop two pointers
        int iL = 0, iR = 0, k = left;

        while(nL > iL && nR > iR) {

            // compare Left ele and Right ele
            if (Left.get(iL).compareTo(Right.get(iR)) <= 0) {

                this.elements[k] = Left.get(iL);
                iL++;
            } else {
                this.elements[k] = Right.get(iR);
                iR++;
            }
            k++;
        }

        // Right or Left remain elements, not yet placed.
        while (iR < nR) {
            this.elements[k] = Right.get(iR);
            iR++;k++;
        }
        while (iL < nL) {
            this.elements[k] = Left.get(iL);
            iL++;k++;
        }
    }

    private int partition(T[] a, int left, int right) {

        int pointer = right, i = left;
        boolean isRearrange = false;

        while (i < right) {

            if (a[i].compareTo(a[right]) >= 0 && !isRearrange) {

                pointer = i;
                isRearrange = true;
            }
            else if (a[i].compareTo(a[right]) < 0 && isRearrange) {
//                if (pointer != -1) {
                // swapping
                T tmp = a[pointer];
                a[pointer] = a[i];
                a[i] = tmp;
                pointer++;
//                }
            }
            i++;
        }
        try {
            T tmp = a[pointer];
            a[pointer] = a[right];
            a[right] = tmp;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return pointer;
    }

    public void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(this.elements, left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }
}
