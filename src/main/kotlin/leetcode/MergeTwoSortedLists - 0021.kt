package leetcode


// Example:
// var li = ListNode(5)
//var v = li.`val`
// Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return ("${this.`val`} -> ${this.next}")
    }
}


class Solution {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var l1 = ListNode(1)
            var temp = ListNode(2)
            l1.next = temp
            temp.next = ListNode(4)


            var l2 = ListNode(1)
            var temp2 = ListNode(3)
            l2.next = temp2
            temp2.next = ListNode(4)

        }


        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

            if (l1 == null) return l2
            if (l2 == null) return l1

            val temp = ListNode(if (l1.`val` > l2.`val`) l2.`val` else l1.`val`)
            temp.next =
                mergeTwoLists((if (l1.`val` > l2.`val`) l1 else l2.next), if (l1.`val` > l2.`val`) l2.next else l2)
            return temp


        }


    }
}
