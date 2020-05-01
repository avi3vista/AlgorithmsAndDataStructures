package leetcode

class NumberOfSubArraysWithAverage {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val arr = arrayOf(11,13,17,23,29,31,7,5,2,3).toIntArray()
            val k = 3
            val threshold = 5

            print(numOfSubarrays(arr, k, threshold))

        }

        fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
            var count = 0;
            var startIndex = 0
            var endIndex = k-1
            var currAvg = 0.0
            for(num in startIndex..endIndex-1) {
                println(arr[num])
                currAvg+= arr[num]/(k*1.0)
            }
            while(endIndex<arr.size) {
                currAvg+=arr[endIndex]/(k*1.0)
                if(currAvg>=threshold) {
                    count++
                }
                currAvg-=arr[startIndex]/(k*1.0)
                startIndex++
                endIndex++

            }
            return count
        }
    }

}