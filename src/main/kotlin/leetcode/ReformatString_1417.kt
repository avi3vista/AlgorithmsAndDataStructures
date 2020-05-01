package leetcode

class ReformatString_1417 {

    fun reformat(s: String): String {
        val alphabets = mutableListOf<Char>()
        val numbers = mutableListOf<Char>()
        var result: StringBuffer = StringBuffer()

        s.forEach { c -> if (c.isDigit()) numbers.add(c) else alphabets.add(c) }
        if ((alphabets.size - numbers.size) > 1 || (alphabets.size - numbers.size) < -1) return result.toString()

        if (alphabets.size > numbers.size) {
            alphabets.forEachIndexed { i, c ->
                result.append(c).append(numbers[i])
                if(i<numbers.size)    result.append(numbers[i])
            }
        } else {
            numbers.forEachIndexed { i, c ->
                result.append(c)
                if(i<alphabets.size)    result.append(alphabets[i])
            }
        }
        return result.toString()
    }
}