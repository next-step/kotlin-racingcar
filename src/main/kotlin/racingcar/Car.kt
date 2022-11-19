package racingcar

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(value: Int) {
        if (value >= FORWARD_NUMBER) position++
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
    }
}
