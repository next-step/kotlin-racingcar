package racingcar.domain

import racingcar.strategy.MoveStrategy
import racingcar.strategy.RandomStrategy

class Car(val name: String, position: Int = DEFAULT_POSITION, val moveStrategy: MoveStrategy = RandomStrategy()) {
    var position = position
        private set

    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) { "Car의 이름은 빈 문자열이 아니고 5자 이하의 문자열만 허용됩니다." }
    }

    fun move(): Int {
        if (moveStrategy.canMove()) {
            position++
        }

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 1
        private const val MAX_NAME_LENGTH = 5
    }
}
