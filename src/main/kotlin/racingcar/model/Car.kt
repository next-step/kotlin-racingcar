package racingcar.model

class Car(
    private var currentProgress: Int = 0
) {
    fun moveForward() {
        currentProgress += 1
    }

    fun getPosition(): Int {
        return currentProgress
    }
}
