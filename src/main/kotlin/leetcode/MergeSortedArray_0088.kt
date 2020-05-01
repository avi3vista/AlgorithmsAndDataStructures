package leetcode

class MergeSortedArray_0088 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums1 = intArrayOf(-1,0,0,3,3,3,0,0,0)
            val nums2 = intArrayOf(1,200,400)
            val m =6;
            val n = 3;



            nums1.forEach {
                print( "$it  ")
            }
            println("after result")

            merge(nums1, m, nums2, n)

            nums1.forEach {
                print( "$it  ")
            }

        }


        private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            val tempList = mutableListOf<Int>()
            var nums2Index = 0
            var nums1Index = 0

            nums1.forEachIndexed { i, num ->
                tempList.add(nums1[i])
                when {
                    nums1Index>=m -> nums1[i]=nums2[nums2Index++]
                    nums2Index>=n -> {
                        nums1[i]= tempList[0]
                        tempList.removeAt(0)
                        nums1Index++
                    }
                    tempList[0]<nums2[nums2Index] -> {
                        nums1[i]=tempList[0]
                        nums1Index++
                        tempList.removeAt(0)
                    }
                    else -> nums1[i]=nums2[nums2Index++]
                }
            }

        }
    }
}