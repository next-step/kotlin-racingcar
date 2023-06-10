package racingcar.domain

class Car(name: String) {
    private val carName = CarName(name)

    var position = 0
        private set

    fun go(moveCondition: MoveCondition) {
        if (moveCondition.isMovable()) {
            position++
        }
    }

    fun getCarNameString(): String {
        return carName.name
    }
}
