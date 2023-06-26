package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Car(
    private val movingStrategy: MovingStrategy,
    val name: String,
) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move() {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0

        fun of(name: String, movingStrategy: MovingStrategy): Car {
            require(name.trim().length in 1..5) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다." }
            return Car(movingStrategy, name)
        }
    }
}
