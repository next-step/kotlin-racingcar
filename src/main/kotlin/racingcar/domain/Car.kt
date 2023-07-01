package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Car(
    private val movingStrategy: MovingStrategy,
    private val name: CarName,
) {
    var position: Int = DEFAULT_POSITION
        private set

    constructor(movingStrategy: MovingStrategy, name: String) : this(movingStrategy, CarName(name))

    fun move() {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    fun getCurrentInfo() = CarInfo(name.value, position)

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
