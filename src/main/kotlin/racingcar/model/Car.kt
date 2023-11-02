package racingcar.model

import java.lang.IllegalArgumentException

class Car(
    val name: String,
    position: Int = 0,
    private val moveCondition: MoveCondition = RandomMovement(),
) {
    var position: Int = position
        private set

    init {
        require(name.length <= 5) { throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.") }
    }

    fun move() {
        if (moveCondition.isMovable()) {
            position++
        }
    }
}
