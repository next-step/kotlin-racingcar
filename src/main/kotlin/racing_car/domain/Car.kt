package racing_car.domain

class Car(
    private var _position: Int = 0,
    private val _moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy(),
) {

    val position: Int
        get() = _position

    fun move() {
        if (_moveStrategy.canMove()) {
            _position++
        }
    }

    fun copy(): Car {
        return Car(_position = _position, _moveStrategy = _moveStrategy)
    }
}
