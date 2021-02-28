package racingcar.model

class Car(
    private var currentPosition: Int = 0
) {
    fun moveForward() {
        currentPosition += 1
    }

    fun getPosition(): Int {
        return currentPosition
    }
}
