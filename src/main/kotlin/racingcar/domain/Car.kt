package racingcar.domain

class Car(
    private var position: Int = 0,
    private val movingStrategy: MovingStrategy,
) {
    fun move() {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}
