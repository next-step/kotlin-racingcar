package racingcar.domain.car

import racingcar.domain.car.engine.MovingEngine
import racingcar.domain.car.engine.implement.DefaultMovingEngine
class Car(
    private val movingEngine: MovingEngine = DefaultMovingEngine()
) {

    private var position: Position = Position()
    private var stop: Boolean = false
    private var attemptCount: Count = Count()

    fun currentPosition() = this.position

    fun move() {
        checkStop()
        this.position = movingEngine.move(this.position)
        addAttemptCount()
    }

    private fun checkStop() {
        check(!stop) { "자동차는 이미 정지한 상태입니다" }
    }

    private fun addAttemptCount() {
        this.attemptCount = this.attemptCount.add()
    }

    fun attemptCount(): Int = this.attemptCount.toInt()
}
