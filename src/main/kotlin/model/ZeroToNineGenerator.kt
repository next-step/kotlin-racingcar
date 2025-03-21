package model

import kotlin.random.Random

private const val MIN_RANDOM_NUMBER = 0
private const val MAX_RANDOM_NUMBER = 10

class ZeroToNineGenerator : RandomNumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
