package racingcar.domain.car

import racingcar.domain.Moving
import racingcar.domain.Name

data class Car(val name: Name, val position: Int = DEFAULT_POSITION) {
    fun move(moving: Moving): Car {
        if (moving.value >= MOVE_CONDITION) return copy(position = position + 1)
        return this
    }

    companion object {
        private const val MOVE_CONDITION = 4
        private const val DEFAULT_POSITION = 0
    }
}
