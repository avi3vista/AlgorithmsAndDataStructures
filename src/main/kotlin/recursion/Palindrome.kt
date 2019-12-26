package recursion

import java.util.logging.Logger

fun main() {
    val lg = Logger.getLogger("Palindrome")
    val str = "Bob"
    lg.info("is ${str} palindrome ? : ${checkPalindrome(str.toCharArray(), 0, str.length-1)}")
}

private fun checkPalindrome(str: CharArray, strIdx: Int, endIdx: Int): Boolean {
    if(strIdx>=endIdx){
        return true
    }
    return str[strIdx]==str[endIdx] && checkPalindrome(str, strIdx+1, endIdx-1)

}
