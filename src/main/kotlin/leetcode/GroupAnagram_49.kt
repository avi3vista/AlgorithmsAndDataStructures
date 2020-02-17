package leetcode

class GroupAnagram_49{


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val s = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

            print(groupAnagrams(s))

        }

        private fun groupAnagrams(strs: Array<String>): Any? {
            val map = mutableMapOf<String, MutableList<String>>()
            for(str in strs) {
                val tempStr = String(str.toCharArray().sortedArray())
                var listOfString = map.getOrDefault(tempStr, mutableListOf())
                listOfString.add(str)
                map.put(tempStr,listOfString)
            }
            return map.values.toList();

        }


        fun groupAnagramsUsingCharCountMap(strs: Array<String>): List<List<String>> {

            val map = mutableMapOf<Map<Char, Int>, MutableList<String>>()
            for(str in strs) {
                val tempMap = str.groupingBy { it }.eachCount()
                var listOfString = map.getOrDefault(tempMap, mutableListOf())
                listOfString.add(str)
                map.put(tempMap,listOfString)
            }
            return map.values.toList();

        }
    }
}