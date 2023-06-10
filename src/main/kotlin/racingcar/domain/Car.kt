package racingcar.domain

import java.util.Random

class Car(
    position: Int = INIT_POSITION,
    private val carName: CarName,
    private val movable: () -> Boolean,
) {
    val name: String
        get() = carName.value

    var position: Int = position
        private set

    fun move(): Int {
        if (movable()) {
            return ++position
        }
        return position
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MAX_RANDOM_MOVE_INPUT = 9
        private const val MOVABLE_VALUE = 4
        private val random = Random()

        fun createRandomMoveCar() = Car(carName = CarName("tmp")) { random.nextInt(MAX_RANDOM_MOVE_INPUT) >= MOVABLE_VALUE }
    }
}
