package racingcar.domain

import racingcar.domain.move.Movable

class Car(private val movable: Movable, val name: String) {
    var location = 0
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 5글자 미만이여야 합니다." }
    }

    fun move() {
        val isMove = movable.move()
        if (isMove) location++
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}
