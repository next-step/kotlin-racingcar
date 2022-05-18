package racingcar.domain

import racingcar.utils.NumberGenerator

class Car(
    val carName: String,
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

    companion object {
        private const val forwardThreshold: Int = 4
        private val forwardDistanceRange: IntRange = 0..9
    }
}
