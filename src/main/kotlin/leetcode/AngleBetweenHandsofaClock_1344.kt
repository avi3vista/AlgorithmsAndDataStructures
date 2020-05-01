package leetcode

import java.lang.Math.abs
import java.lang.Math.min

class AngleBetweenHandsofaClock_1344 {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val hour = 1
            val min = 57

            print(angleClock(hour, min))

        }

        fun angleClock(hour: Int, minutes: Int): Double {
            val hr = (30*hour + (minutes/2.0).toDouble())%360
            val min = (minutes*6).toDouble()

            println(hr)
            println(min)
            return min(abs(hr-min), 360-abs(min-hr))
        }
    }
}