package racingcar.domain

import racingcar.utils.RandomGenerator

class Car(
    private val forwardThreshold: Int,
    private val forwardDistanceRange: IntRange,
    private val random: RandomGenerator
) {
    var position: Int = 0
        private set

    fun run() {
        if (isRun()) {
            position += 1
        }
    }

    private fun isRun(): Boolean {
        return random.generateNumberWithin(forwardDistanceRange) >= forwardThreshold
    }
}
