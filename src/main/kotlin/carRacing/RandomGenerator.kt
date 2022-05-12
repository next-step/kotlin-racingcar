package carRacing

import kotlin.random.Random

object RandomGenerator {
    private const val MIN = 0
    private const val MAX = 9

    fun value(): Int = Random.nextInt(MIN, MAX)
}
