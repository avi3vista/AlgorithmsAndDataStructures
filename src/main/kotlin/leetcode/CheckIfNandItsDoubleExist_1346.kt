package leetcode

class CheckIfNandItsDoubleExist_1346 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = arrayOf(
                7,1,14,11
            ).toIntArray()
            print(checkIfExist(arr))
        }

        fun checkIfExist(arr: IntArray): Boolean {
            var set = mutableSetOf<Int>()
            arr.forEach { num ->
                if((num %2 ==0 && set.contains(num/2)) || set.contains(num*2)) {
                    return true
                }
                else {
                    set.add(num)
                }
            }
            println(set)
            return false
        }
    }
}