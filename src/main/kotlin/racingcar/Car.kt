package racingcar

import racingcar.condition.MoveCondition

class Car(val name: String, position: Int, private val condition: List<MoveCondition>) {
    var position: Int = position
        private set

    fun move(): Int {
        if (isMovable()) {
            position = position.plus(SPEED)
        }
        return position
    }

    private fun isMovable(): Boolean {
        return condition.any { it.available() }
    }

    companion object {
        const val SPEED = 1
    }
}
