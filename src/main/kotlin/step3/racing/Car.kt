package step3.racing

class Car(
    private var step: Int = DEFAULT_VALUE
) {
    fun moveForward() {
        step += ONE_STEP
    }

    fun currentStep(): Int = step

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val ONE_STEP = 1
    }
}
