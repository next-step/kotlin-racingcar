package racingcar.domain

class Car(val name: String, position: Int = 0, private val moveStrategy: MoveStrategy = MoveStrategy { true }) {

    var position = position
        private set

    fun move() {
        if (moveStrategy.isMovable())
            position++
    }
}
