package sorting;

import java.util.Arrays;

public class MergeSorting {
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        //creating temporary subarrays
        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];

        //copying our sorted subarrays ino temporaries
        for (int i = 0; i < lengthLeft ; i++) {
            leftArray[i] = array[left+i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[mid+i+1];
        }

        // iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // copying from leftArray and rightArray back into array
        for (int i = left; i < right+1; i++) {
            if (leftIndex<lengthLeft && rightIndex < lengthRight){
                if (leftArray[leftIndex] < rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < lengthLeft){
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < lengthRight){
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

        mergeSort(a,0,a.length-1);

        System.out.println(Arrays.toString(a));

//        int[] array = new int[10000];
//        for (int i = 0; i <array.length; i++) {
//            array[i] = i;
//        }
//
//        Collections.shuffle(Arrays.asList(array));
//
//        System.out.println(Arrays.toString(array));
//
//        long startTime = System.nanoTime();
//        mergeSort(array,0,array.length-1);
//        long endTime = System.nanoTime();
//
//        System.out.println(Arrays.toString(array));
//
//        System.out.println();
//
//        System.out.println("Merge Sort runtime: " + (endTime - startTime));
    }
}
