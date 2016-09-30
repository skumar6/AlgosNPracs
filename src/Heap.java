/**
 * Created by Sanjeev on 5/11/2016.
 */
public class Heap {

    static int heapSize;
    public static void main(String[] args){
        int[] arr = {4,1,3,2,16,9,10,14,8,7};
        printarr(buildHeap(arr));
        System.out.println("");
        heapSort(arr);
    }

    //create heap from a pointer, it's a max heap, maximim element will be
    //always on the top, and every parent ll be greater than its children
    //for detailed understanding follow and see CLRS
    private static void maxHeapify(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if(l<heapSize && arr[l] > arr[i]){
            largest = l;
        }else{
            largest = i;
        }
        if(r<heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i){
            exchange(i, largest, arr);
            maxHeapify(arr, largest);
        }

    }

    //form a sorted array from heap
    public static void heapSort(int[] arr){
        buildHeap(arr);
        for(int i = arr.length-1; i>=0; i--){
            exchange(i, 0, arr);
            heapSize = heapSize-1;
            maxHeapify(arr,0);
        }
        printarr(arr);
    }

    //make heap from an array, run maxheapify on half the elements,
    //because rest half will be leaves ll be always on the bottom.
    public static int[] buildHeap(int[] arr){
        heapSize = arr.length;
        for(int i = arr.length/2; i>=0; i--){
            maxHeapify(arr, i);
        }
        return arr;

    }
    //swap elements
    private static void exchange(int i, int largest, int[] arr) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;

    }
    //right child
    private static int right(int i) {
        return 2*i +2;
    }

    //left child
    private static int left(int i) {
        return 2*i+1;
    }

    //given a node, find its parent
    private int  parent(int i){
        return i/2;
    }

    //printing the array
    private static void printarr(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }

    }
}
