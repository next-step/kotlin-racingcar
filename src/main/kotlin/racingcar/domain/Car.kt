package racingcar.domain

class Car(position: Int = 0, private val moveStrategy: MoveStrategy) {

    var position = position
        private set

    fun move() {
        if (moveStrategy.isMovable())
            position++
    }
}
