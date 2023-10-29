package util

import kotlin.random.Random

object RandomNumberGenerator {
    fun generate(range: IntRange): Int {
        return Random.nextInt(range.first, range.last + 1)
    }
}
