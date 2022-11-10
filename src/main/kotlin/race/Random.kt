package race

import java.util.Random

object Random {
    private val random = Random()
    private const val RANDOM_FIRST = 0
    private const val RANDOM_LAST = 9

    fun generateRandomNumber(): Int = random.nextInt(RANDOM_LAST - RANDOM_FIRST) + RANDOM_FIRST
}
