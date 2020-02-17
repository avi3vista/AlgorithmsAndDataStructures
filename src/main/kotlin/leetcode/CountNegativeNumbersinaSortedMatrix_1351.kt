package leetcode

class CountNegativeNumbersinaSortedMatrix_1351 {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grid = arrayOf(arrayOf(4,3,2,-1).toIntArray(),
                arrayOf(3,2,1,-1).toIntArray(),
                arrayOf(1,1,-1,-2).toIntArray(),
                arrayOf(-1,-1,-2,-3).toIntArray())
            print(countNegatives(grid))
        }

        fun countNegatives(grid: Array<IntArray>): Int {
            var count = 0

            grid.forEach { row->
                count+=row.count { it <0 }
            }

            return count

        }

    }
}