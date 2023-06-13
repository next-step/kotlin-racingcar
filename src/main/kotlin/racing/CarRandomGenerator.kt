package racing

import kotlin.random.Random

object CarRandomGenerator {

    private const val MIN_RANGE = 0

    fun createRandom(range: Int): Int {
        return Random.nextInt(MIN_RANGE, range)
    }
}
