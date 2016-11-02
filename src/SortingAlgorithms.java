/**
 * Created by Sanjeev on 10/31/2016.
 */
public class SortingAlgorithms {

    public static void bubbleSort(int[] arr){
        if(arr==null)
            return;
        for(int i=arr.length-1; i>=0; i--){
            for(int j =1; j<i; j++){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i =0; i<arr.length; i++){
            int index = i;
             for(int j =i; j<arr.length; j++){
                 if(arr[j]<arr[index])
                     index = j;
             }
            swap(arr, index, i);
        }
    }

    public static void insertionSort(int[] arr){
        for(int i =0; i<arr.length; i++){
            for(int j =i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static void quickSort(int[] arr, int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int m = lowerIndex + (higherIndex-lowerIndex)/2;
        while(i<=j){
            while(arr[i] < arr[m]){
                i++;
            }
            while(arr[j]>arr[m]){
                j--;
            }
            if(i<=j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if(i< higherIndex) quickSort(arr, i, higherIndex);
        if(j> lowerIndex) quickSort(arr, lowerIndex, j);
    }

    public static int[] mergeSort(int[] arr){
        int n = arr.length;
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        if(n<=1) return arr;

        for(int i =0; i<a.length; i++)
            a[i]=arr[i];

        for(int i =0; i<b.length; i++)
            b[i]=arr[i+n/2];

        return merge(mergeSort(a), mergeSort(b));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        int i=0, j=0;
        for(int k =0; k<c.length; k++){
            if(i>=a.length) c[k]=b[j++];
            else if(j>= b.length) c[k]= a[i++];
            else if(a[i] < b[j]) c[k] = a[i++];
            else c[k] = b[j++];
        }
        printArr(c);
        return c;

    }


    public static void printArr(int[] arr){
        if(arr==null) return;
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args){
        int[] arr = {2,3,1,6,5,9,7,8};
        //bubbleSort(arr);
        printArr(arr);

        //selectionSort(arr);
        //insertionSort(arr);
       // quickSort(arr, 0, arr.length-1);

        printArr(mergeSort(arr));
    }
}
