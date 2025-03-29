package racingcar.domain.car

import racingcar.domain.Name

data class Car(val name: Name, val position: Int = DEFAULT_POSITION) {
    fun moveOverCondition(number: Int): Car {
        if (number >= MOVE_CONDITION) return copy(position = position + FORWARD_VALUE)
        return this
    }

    companion object {
        private const val MOVE_CONDITION = 4
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_VALUE = 1
    }
}
