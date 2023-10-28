package step3.racing

import kotlin.random.Random

class Car(
    private var step: Int = DEFAULT_VALUE
) {
    fun moveForward() {
        if (canGo()) step += ONE_STEP
    }

    fun currentStep(): Int = step

    private fun canGo(): Boolean {
        return Random.nextInt(from = FROM_ZERO, until = UNTIL_TEN) >= CAN_GO_NUMBER
    }

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val ONE_STEP = 1
        private const val FROM_ZERO = 0
        private const val UNTIL_TEN = 10
        private const val CAN_GO_NUMBER = 4
    }
}
