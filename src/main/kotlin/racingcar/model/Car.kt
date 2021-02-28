package racingcar.model

class Car(
    private var currentProgress: Int = 0
) {
    fun moveForward() {
        currentProgress += 1
    }

    fun getProgress(): Int {
        return currentProgress
    }
}
