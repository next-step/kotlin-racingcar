package racingcar.domain

class Car(
    private val movingStrategy: MovingStrategy,
    private var position: Int = 0,
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
