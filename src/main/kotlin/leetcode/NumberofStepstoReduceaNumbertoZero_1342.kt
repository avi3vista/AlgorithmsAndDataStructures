package leetcode

class NumberofStepstoReduceaNumbertoZero_1342 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val num = 8
            print(numberOfSteps(num))

        }

        fun numberOfSteps (num: Int): Int {
            var count = 0;
            var tempNum = num
            while(tempNum!=0) {
                if(tempNum%2==0) {
                    tempNum=tempNum/2
                }
                else {
                    tempNum=tempNum-1
                }
                count++
            }

            return count
        }
    }

}