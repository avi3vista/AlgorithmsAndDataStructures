package leetcode

class RottingOranges_0994 {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var arr = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf( 0, 1,1))
            printArray(arr)
            println(orangesRotting(arr))
        }

        private fun printArray(arr: Array<IntArray>) {
            arr.forEach { row ->
                println(
                    row.forEach { print("${it} ") }
                )
            }
        }


        fun orangesRotting(grid: Array<IntArray>): Int {
            var newGrid = grid
            var hasFresh = hasFresh(grid)
            var totalMinutes = 0
            var nextArr = getNextArr(grid)
            if(hasFresh && nextArr.size==0) return -1

            while (hasFresh  && nextArr.size>0) {
                totalMinutes++
                newGrid = rotOranges(newGrid, nextArr)
                hasFresh = hasFresh(newGrid)
                nextArr = getNextArr(newGrid)
            }

            return if(hasFresh) -1 else totalMinutes

        }

        private fun rotOranges(newGrid: Array<IntArray>, nextArr: List<List<Int>>): Array<IntArray> {
            nextArr.forEach {
                newGrid[it[0]][it[1]] = 2
            }
            return newGrid
        }

        private fun printArray(arr: List<List<Int>>) {
            arr.forEach { row ->
                println(
                    row.forEach { print("${it} ") }
                )
            }
        }

        private fun getNextArr(grid: Array<IntArray>): List<List<Int>> {
            var res = mutableListOf<MutableList<Int>>()
            val rowSize = grid.size
            val colSize = grid.firstOrNull()?.size ?: 0
            grid.forEachIndexed { r, row ->
                row.forEachIndexed { c, ele ->
                    if (ele.equals(2)) {
                        if (c - 1 >= 0 && grid[r][c-1]==1) res.add(mutableListOf(r, c - 1))
                        if (c + 1 < colSize && grid[r][c+1]==1) res.add(mutableListOf(r, c + 1))
                        if (r - 1 >= 0 && grid[r-1][c]==1) res.add(mutableListOf(r - 1, c))
                        if (r + 1 < rowSize && grid[r+1][c]==1) res.add(mutableListOf(r + 1, c))
                    }
                }

            }
            return res

        }

        private fun hasFresh(grid: Array<IntArray>): Boolean {
            return grid.filter { row ->
                row.filter { it.equals(1) }.isNotEmpty()
            }.isNotEmpty()

        }

    }

}