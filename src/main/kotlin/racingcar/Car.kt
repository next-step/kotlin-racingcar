package racingcar

class Car(
    var position: Int = 0
) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position++
        }
    }
}
