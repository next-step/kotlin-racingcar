package racingcar

import kotlin.random.Random

class Car {
    var position = 1
        private set

    var valueGenerator: (() -> Int)? = null
    private val defaultGenerator: () -> Int = { Random.nextInt(DEFAULT_GENERATION_RANGE) }

    fun proceed() {
        val seedValue = valueGenerator?.invoke() ?: defaultGenerator.invoke()

        if (canGo(seedValue)) {
            position++
        }
    }

    private fun canGo(randomValue: Int, threshold: Int = GO_THRESHOLD): Boolean {
        return randomValue >= threshold
    }

    companion object {
        private const val GO_THRESHOLD = 4
        private const val DEFAULT_GENERATION_RANGE = 10
    }
}