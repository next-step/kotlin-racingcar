package racing.domain

import racing.domain.strategy.MovingStrategy

class Car(
    val name: String,
    private val movingStrategy: MovingStrategy
) {
    init {
        require(name.isNotBlank()) { "이름은 빈 문자열이 될 수 없습니다." }
        require(name.length <= NAME_MAX_LENGTH) { "이름의 길이는 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다. : $name" }
    }

    var position: Int = 0
        private set

    fun move() {
        if (movingStrategy.isMove()) {
            position += ONE_MOVE_VALUE
        }
    }

    companion object {
        const val ONE_MOVE_VALUE = 1
        const val NAME_MAX_LENGTH = 5
    }
}
