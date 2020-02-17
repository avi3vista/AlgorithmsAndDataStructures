package leetcode

class ValidAnagram_242 {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val s = "xysabab"
            val t = "ab"
            print(isAnagram(s, t))

        }


        fun isAnagram(s: String, t: String): Boolean {


            return s.groupingBy { it }.eachCount().equals(t.groupingBy { it }.eachCount())
        }
    }



}