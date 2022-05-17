package step3.model

import step3.util.NumberGenerator
import step3.util.RandomGenerator

class Car(val name: String, private val numberGenerator: NumberGenerator = RandomGenerator) {
    init {
        require(name.trim().length in NAME_LENGTH_RANGE) { "Invalid Name Length" }
    }

    fun move(): Boolean {
        return isMovable()
    }

    private fun isMovable(): Boolean {
        return MOVABLE_THRESHOLD <= numberGenerator.generate(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
        const val MOVABLE_THRESHOLD = 4
        val NAME_LENGTH_RANGE = (1..5)
    }
}
