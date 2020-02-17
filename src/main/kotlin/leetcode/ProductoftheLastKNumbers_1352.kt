package leetcode

class ProductOfNumbers() {

    val list = mutableListOf<Int>()
    fun add(num: Int) {
        list.add(0,num)
    }

    fun getProduct(k: Int): Int {
        var res = 1
        list.take(k).forEach { res*=it }
        return res
    }

}