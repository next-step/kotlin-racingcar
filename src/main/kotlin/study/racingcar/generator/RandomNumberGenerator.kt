package study.racingcar.generator

import kotlin.random.Random

class RandomNumberGenerator : Generator {
    override fun generate(): Int {
        return Random.nextInt(0, MAXIMUM_NUMBER)
    }

    companion object {
        private const val MAXIMUM_NUMBER = 9
    }
}
