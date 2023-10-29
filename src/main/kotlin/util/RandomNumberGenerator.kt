package util

import kotlin.random.Random

object RandomNumberGenerator {
    fun generate(from: Int, until: Int): Int {
        return Random.nextInt(from, until)
    }

    fun generate(range: IntRange): Int {
        return Random.nextInt(range.first, range.last + 1)
    }
}
