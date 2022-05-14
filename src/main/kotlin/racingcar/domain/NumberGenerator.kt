package racingcar.domain

import kotlin.random.Random

fun interface NumberGenerator {
    fun generate(from: Int, until: Int): Int
}

object RandomNumberGenerator : NumberGenerator {
    override fun generate(from: Int, until: Int): Int {
        return Random.nextInt(from, until)
    }
}
