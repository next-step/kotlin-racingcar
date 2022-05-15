package racingcar.domain

import racingcar.utils.NumberGenerator

class Car(
    private val forwardThreshold: Int,
    private val forwardDistanceRange: IntRange,
    private val numberGenerator: NumberGenerator
) {
    var position: Int = 0
        private set

    fun run() {
        if (isRun()) {
            position += 1
        }
    }

    private fun isRun(): Boolean {
        return numberGenerator.executeRangeOf(forwardDistanceRange) >= forwardThreshold
    }
}
