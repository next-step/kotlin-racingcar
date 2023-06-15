package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

private const val MAXIMUM_NAME_LENGTH = 5

class Car(val name: String, score: Int = 0) {

    var score: Int = score
        private set

    init {
        require(name.length < MAXIMUM_NAME_LENGTH) { "자동차이름은 5자를 초과할 수 없습니다." }
    }

    fun move(strategy: MoveStrategy) {
        if (strategy.move()) {
            this.score++
        }
    }
}
