package racingcar.domain

class Car(name: String, moveCondition: MoveCondition) {
    private val _carName = CarName(name)
    private val _moveCondition = moveCondition

    var position = 0
        private set

    fun go() {
        if (this._moveCondition.isMovable()) {
            position++
        }
    }

    fun getName(): String {
        return _carName.name
    }
}
