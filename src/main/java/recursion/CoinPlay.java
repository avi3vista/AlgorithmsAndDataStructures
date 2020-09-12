package recursion;

import java.util.logging.Logger;

public class CoinPlay {

    public static void main (String[] var) {
        Logger lg = Logger.getLogger("CoinPlay");
        int[] arr = {8,15,3,7};
        int value = findValue(arr,0,arr.length-1,0);
        lg.info("value for arr " + arr + " = " + value);

    }

    private static int findValue (int[] arr, int leftIdx, int rightIdx, int count) {
        Logger lg = Logger.getLogger("CoinPlay");
        if(leftIdx>=rightIdx) {
            return 0;
        }
        int left = findValue(arr, (leftIdx+1), rightIdx, count+1);
        int right = findValue(arr, leftIdx, (rightIdx-1), count+1);

        lg.info("left value for arr with leftidx " + (leftIdx+1) + " and rightIdx " + rightIdx + " = " + left);
        lg.info("right value for arr with leftidx " + leftIdx + " and rightIdx " + (rightIdx-1) + " = " + right);
        int max = Math.min(left, right);
        if (count%2==0) {
            if(arr[leftIdx]+ left>arr[rightIdx]+right) {
                max = arr[leftIdx] + left;
            }
            else {
                max=arr[rightIdx] + right;
            }
        }
        return max;

       /* if(count%2==0) {
            return Math.max(arr[leftIdx]+ findValue(arr, (leftIdx+1), rightIdx, count+1),
                    arr[rightIdx]+ findValue(arr, leftIdx, (rightIdx-1), count+1));
        }
        return Math.min(findValue(arr, (leftIdx+1), rightIdx, count+1),
                findValue(arr, leftIdx, (rightIdx-1), count+1));
*/
    }
}
