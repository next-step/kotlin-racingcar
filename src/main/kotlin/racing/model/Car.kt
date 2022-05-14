package racing.model

import racing.Movable

class Car(private var position: Int) {
    init {
        require(position >= 0) { "자동차의 초기 위치는 0이상 입니다." }
    }

    fun move(movable: Movable): Int {
        if (movable.canMove())
            position++
        return position
    }
}
