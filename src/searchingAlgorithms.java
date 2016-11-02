/**
 * Created by Sanjeev on 11/2/2016.
 */
public class searchingAlgorithms {

    public static int binarySearchRecursive(int[] arr, int l, int r, int ele){

        if(r>=l){
            int m  = l + (r-l)/2;
            if(arr[m]== ele) return m;

            if(arr[m]>ele)
                 return binarySearchRecursive(arr, l, m-1, ele);
            else
                 return binarySearchRecursive(arr, m+1, r, ele);
        }
        return -1;
    }

    public static int  binarySearchIterative(int[] arr, int l, int r, int ele){
        while(l<=r){
            int m = l + (r-l)/2;
            if(arr[m]== ele) return m;

            if(arr[m]>ele) r = m-1;
            else l = m+1;

        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        int f = binarySearchIterative(arr, 0, arr.length-1, 0);
        System.out.println(f);
    }
}
