package racingcar.domain

import racingcar.domain.move.Movable

class Car(private val movable: Movable, val name: String) {
    var location = 0
        private set

    fun move() {
        val isMove = movable.move()
        if (isMove) location++
    }
}
