package racingcar.domain

import racingcar.domain.strategy.MovableStrategy

data class Car(
    val name: String,
    var position: Int = DEFAULT_POSITION,
) {
    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) { "자동차 이름은 5글자를 초과할 수 없습니다." }
    }

    fun move(movableStrategy: MovableStrategy): Car {
        if (movableStrategy.isMovable()) position++

        return this
    }

    companion object {
        const val DEFAULT_POSITION = 0
        const val MAX_CAR_NAME_LENGTH = 5
    }
}
