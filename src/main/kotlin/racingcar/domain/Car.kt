package racingcar.domain

class Car {
    var position: Int = 0
        private set

    fun move(condition: Int) {
        if (condition >= CONDITION_TO_MOVE) {
            position++
        }
    }

    companion object {
        private const val CONDITION_TO_MOVE: Int = 4
    }
}
