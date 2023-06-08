package racingcar.domain

import java.util.Random

class Car(
    var position: Int = 0,
    private val movable: () -> Boolean,
) {
    fun move(): Int {
        if (movable.invoke()) {
            return ++position
        }
        return position
    }

    companion object {
        private const val MAX_RANDOM_MOVE_INPUT = 9
        private const val MOVABLE_VALUE = 4
        private val random = Random()

        fun createRandomMoveCar() = Car { random.nextInt(MAX_RANDOM_MOVE_INPUT) >= MOVABLE_VALUE }
    }
}
