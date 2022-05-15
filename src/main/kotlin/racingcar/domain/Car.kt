package racingcar.domain

class Car(
    val position: Int = 0,
) {
    fun move(number: Int): Int {
        val moveOneStepOrNot = if (number >= LOWER_BOUND_TO_MOVE) MOVE else STOP
        return position.plus(moveOneStepOrNot)
    }

    companion object {
        const val MOVE = 1
        const val STOP = 0
        const val LOWER_BOUND_TO_MOVE = 4
    }
}
