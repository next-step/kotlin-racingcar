package step3.domain.car

import step3.domain.car.strategy.MovingStrategy
import step3.domain.car.strategy.implement.DefaultMovingStrategy

class Car(
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy()
) {

    private var position: Position = Position()
    private lateinit var lastPosition: Position

    fun isCurrentPosition(): Position = this.position

    fun move() {
        this.position = movingStrategy.move(this.position)
    }

    fun stop() {
        this.lastPosition = isCurrentPosition()
    }

    fun lastPosition() = this.lastPosition
}
