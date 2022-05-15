package racingcar.domain

class Car(
    val position: Int,
    val name: String,
) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없어요." }
    }

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
