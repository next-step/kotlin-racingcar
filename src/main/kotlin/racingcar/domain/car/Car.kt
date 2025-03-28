package racingcar.domain.car

import racingcar.domain.Moving
import racingcar.domain.Name

class Car(val name: Name) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(moving: Moving) {
        if (moving.value >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val MOVE_CONDITION = 4
        private const val DEFAULT_POSITION = 0
    }
}
