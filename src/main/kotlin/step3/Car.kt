package step3

class Car {
    var position = 0
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
    }

    companion object {
        val instance: Car
            get() = Car()
    }
}
