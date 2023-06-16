package racingcar.domain

class Car(private val movable: Movable) {
    var location = 0
        private set

    fun isMoveOrStop(): Boolean {
        val isMove = movable.move()
        if (isMove) location++
        return isMove
    }
}
