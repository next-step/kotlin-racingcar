package racingcar.domain.car

import racingcar.domain.car.engine.MovingEngine
import racingcar.domain.car.engine.implement.DefaultMovingEngine

class Car(
    private val movingEngine: MovingEngine = DefaultMovingEngine(),
    _name: String? = null
) {

    val name: String = _name ?: "unknown"
    private var position: Position = Position()
    private var stop: Boolean = false
    private var attemptCount: Count = Count()

    init {
        _name?.let { require(it.length <= 5) { "자동차 이름의 길이는 5글자를 초과할 수 없습니다." } }
    }

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
