package racingcar.domain

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(number: Int) {
        if (number >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val MOVE_CONDITION = 4
        private const val DEFAULT_POSITION = 0
    }
}
