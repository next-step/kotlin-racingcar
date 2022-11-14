package study.racingcar.generator

import kotlin.random.Random

class RandomNumberGenerator(private val maximumNumber: Int) : Generator {
    override fun generate(): Int {
        return Random.nextInt(maximumNumber + 1)
    }
}
