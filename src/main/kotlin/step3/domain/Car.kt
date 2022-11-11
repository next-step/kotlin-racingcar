package step3.domain

private const val MOVING_MINIMUM_CONDITION_NUMBER = 4

data class Car(val position: Position = Position(0)) {
    fun move(randomNumber: Int) {
        if (randomNumber >= MOVING_MINIMUM_CONDITION_NUMBER) {
            position.move()
        }
    }
}
