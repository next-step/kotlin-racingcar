package study.step3

import kotlin.random.Random

class RandomNumberGenerator(private val maximumNumber: Int) {
    fun generate(): Int {
        return Random.nextInt(this.maximumNumber + 1)
    }
}
