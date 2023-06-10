package racingcar.domain

import kotlin.random.Random

interface RandomGenerator {
    fun generate(from: Int = 0, until: Int): Int
}

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(from: Int, until: Int): Int = Random.nextInt(from = from, until = until)
}
