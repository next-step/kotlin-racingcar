package racingcar

class Car {
    var position: Int = START_POSITION
        private set

    fun forward() {
        position++
    }

    companion object {
        private const val START_POSITION = 0
    }
}
