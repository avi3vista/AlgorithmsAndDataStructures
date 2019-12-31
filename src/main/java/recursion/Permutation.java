package recursion;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        permute(arr,0);
    }

    private static void permute(int[] arr, int i) {
        if(i==arr.length-1) {
            printCustom(arr);
        }

        for(int j=i; j<arr.length; j++) {
            swap(arr, i, j);
            permute(arr, i+1);
            swap(arr, i, j);
        }


    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

    private static void printCustom(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

    }
}
