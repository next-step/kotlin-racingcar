package racingcar

class Car(movement: Int = INITIAL_POSITION) {
    var movement: Int = movement
        private set

    fun move() {
        this.movement = movement + MOVEMENT_AMOUNT
    }

    companion object {
        const val INITIAL_POSITION = 0
        const val MOVEMENT_AMOUNT = 1
    }
}
