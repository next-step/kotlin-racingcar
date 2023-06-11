package racingcar.domain

class Car(name: String, private val moveCondition: MoveCondition) {
    private val _carName = CarName(name)

    var position = 0
        private set

    fun go() {
        if (this.moveCondition.isMovable()) {
            position++
        }
    }

    fun getName(): String {
        return _carName.name
    }
}
