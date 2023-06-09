package racingcar.domain

import java.util.Random

class Car(
    var position: Int = INIT_POSITION,
    val name: String,
    private val movable: () -> Boolean,
) {
    init {
        require(name.isNotBlank()) { "자동차의 이름은 공백이 들어올 수 없다" }
        require(name.length < 5) { "자동차의 이름을 5자를 초과할 수 없다" }
    }

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

        fun createRandomMoveCar() = Car(name = "tmp") { random.nextInt(MAX_RANDOM_MOVE_INPUT) >= MOVABLE_VALUE }
    }
}
