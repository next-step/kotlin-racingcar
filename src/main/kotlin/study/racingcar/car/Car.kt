package study.racingcar.car

import study.racingcar.race.CarState

class Car(
    private val name: String,
    private val moveGenerator: MoveGenerator
) {
    private var position: Int = 0
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        if (moveGenerator.canMove()) position++
    }

    fun getCurrentState(): CarState {
        return CarState(name, position)
    }
}
