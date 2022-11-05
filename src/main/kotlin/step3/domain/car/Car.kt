package step3.domain.car

import step3.domain.car.strategy.MovingStrategy
import step3.domain.car.strategy.implement.DefaultMovingStrategy

class Car(
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy()
) {

    private var position: Position = Position()
    lateinit var lastPosition: Position

    fun currentPosition() = this.position

    fun move() {
        if (::lastPosition.isInitialized) {
            throw IllegalStateException("자동차는 이미 정지한 상태입니다")
        }
        this.position = movingStrategy.move(this.position)
    }

    fun stop() {
        this.lastPosition = currentPosition()
    }
}
