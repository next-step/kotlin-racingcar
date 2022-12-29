package util.racing.generator

import java.util.Random

class RandomNumberGenerator : NumberGenerator {

    companion object {
        private val RANDOM = Random()
        private const val MAX_NUMBER = 9
    }

    override fun generate(): Int {
        return RANDOM.nextInt(MAX_NUMBER)
    }
}
