package racingcar

class Car(private val movingStrategy: MovingStrategy) {
    var position: Int = START_POSITION

    fun attemptsMoveForward() {
        if (movingStrategy.movable()) {
            this.position++
        }
    }

    companion object {
        const val START_POSITION: Int = 1
    }
}
