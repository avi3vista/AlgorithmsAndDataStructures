package leetcode


class FindAllAnagramsInString {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val s = "xysabab"
            val p = "ab"
            val result = findAnagrams(s, p)
            for (element in result) {
                println(element)
            }
        }

        fun findAnagrams(s: String, p: String): List<Int> {
            val res = mutableListOf<Int>()
            val slength = s.length
            val plength = p.length
            if(plength>slength) {
                return res
            }
            val tempMap: MutableMap<Char, Int> = mutableMapOf()
            val pmap = p.groupingBy { it }.eachCount()


            var startIndex=0
            var endIndex = plength-1
            tempMap.putAll(s.subSequence(startIndex, endIndex).groupingBy { it }.eachCount().toMutableMap())
            while(endIndex<slength) {
                tempMap.put(s[endIndex], tempMap.getOrDefault(s[endIndex], 0).plus(1))

                if(tempMap.equals(pmap)) {
                    res.add(startIndex)
                }
                tempMap.put(s[startIndex], tempMap.getOrDefault(s[startIndex], 0).minus(1))
                if(tempMap.getOrDefault(s[startIndex], 0)==0) {
                    tempMap.remove(s[startIndex])
                }
                startIndex++
                endIndex++
            }

            return res
        }

    }
}