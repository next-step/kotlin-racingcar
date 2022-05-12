package utils

import kotlin.random.Random

class RandomGenerator(private val from: Int, private val until: Int) {

    fun generate(): Int = Random.nextInt(from, until)
}
