package leetcode

class TwoSum {


    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val result = twoSum(intArrayOf(3,3),6)
            for (element in result) {
                println(element)
            }
        }

        fun twoSum(nums: IntArray, target: Int): IntArray {
            if(nums.size<2) {
                return IntArray(0)
            }
            val returnArr = IntArray(2)
            val map = hashMapOf<Int, Int>()

            nums.forEachIndexed { index, element ->
                val v: Int? = map.get(target-element)
                if(v!=null) {
                    returnArr.set(0, v)
                    returnArr.set(1, index)
                    return returnArr
                }
                map.put(element,index)
            }


            return returnArr
        }

    }

}