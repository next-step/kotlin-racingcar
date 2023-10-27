package step3.racing

class Car(
    private var step: Int = 0
) {
    fun moveForward() {
        step += 1
    }

    fun currentStep(): Int = step
}
