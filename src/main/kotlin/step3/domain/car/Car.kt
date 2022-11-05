package step3.domain.car

import step3.domain.car.strategy.Count
import step3.domain.car.strategy.MovingStrategy
import step3.domain.car.strategy.implement.DefaultMovingStrategy

class Car(
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy()
) {

    private var position: Position = Position()
    lateinit var lastPosition: Position
    private var attemptCount: Count = Count()

    fun currentPosition() = this.position

    fun move() {
        checkStop()
        this.position = movingStrategy.move(this.position)
        addAttemptCount()
    }

    private fun checkStop() {
        if (::lastPosition.isInitialized) {
            throw IllegalStateException("자동차는 이미 정지한 상태입니다")
        }
    }

    private fun addAttemptCount() {
        this.attemptCount = this.attemptCount.add()
    }

    fun stop() {
        this.lastPosition = currentPosition()
    }

    fun attemptCount(): Int = this.attemptCount.toInt()
}
