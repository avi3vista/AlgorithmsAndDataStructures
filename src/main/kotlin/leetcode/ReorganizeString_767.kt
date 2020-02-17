package leetcode

class ReorganizeString_767 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "aaaabbbcccccccc"
            print(reorganizeString(s))
        }

        fun reorganizeString(S: String): String {
            var map = S.groupingBy { it }.eachCount().toSortedMap().toMutableMap()
            var s = ""
            var i = 0
            var c: Char? = '#'
            while (map.size > 0) {
                c = map.filter { it.key!=c }.maxBy { it.value }?.key
                if(c==null) {
                    return ""
                }
                s+=c
                map.put(c, map.get(c)?.minus(1))
                if (map.get(c) == 0) {
                    map.remove(c)
                }
            }
            return s
        }
    }
}