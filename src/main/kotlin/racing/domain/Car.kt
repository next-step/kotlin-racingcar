package racing.domain

import racing.Movable
import racing.Moving

class Car(private var position: Int, private val movable: Movable) : Moving(movable) {
    init {
        require(position >= 0) { "자동차의 초기 위치는 0이상 입니다." }
    }

    fun move(): Int {
        if (movable.canMove())
            position++
        return position
    }

    fun savePosition(history: MutableList<Int>) {
        history.add(position)
    }
}
