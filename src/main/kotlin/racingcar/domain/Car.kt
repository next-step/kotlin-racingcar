package racingcar.domain

class Car(val name: String = "") {
    var position: Int = 0
        private set

    fun move(value: Int) {
        if (value >= MOVING_THRESHOLD) {
            position++
        }
    }

    companion object {
        private const val MOVING_THRESHOLD = 4
    }
}
