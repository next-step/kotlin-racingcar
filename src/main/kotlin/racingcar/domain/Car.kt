package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Car(
    private val movingStrategy: MovingStrategy,
    private val name: String,
) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move() {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    fun getCurrentInfo(): CarInfo {
        return CarInfo(name, position)
    }

    companion object {
        private const val DEFAULT_POSITION = 0

        fun of(movingStrategy: MovingStrategy, name: String): Car {
            require(name.trim().length in 1..5) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다." }
            return Car(movingStrategy, name)
        }
    }
}
