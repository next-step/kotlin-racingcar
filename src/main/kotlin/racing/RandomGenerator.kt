package racing

import kotlin.random.Random

object RandomGenerator {
    private const val MAX_VALUE = 9
    private const val MIN_VALUE = 0

    fun generate(): Int {
        return Random.nextInt(MAX_VALUE) + MIN_VALUE
    }
}
