package step3

import java.util.Random

interface IntRandom {
    fun next(): Int
    class Smart(private val random: Random, private val bound: Int = Int.MAX_VALUE) : IntRandom {
        override fun next() = random.nextInt(bound)
    }
}
