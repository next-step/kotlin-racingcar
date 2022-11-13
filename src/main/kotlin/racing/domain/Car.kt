package racing.domain

class Car {
    private val MOVING_CONDITION = 4

    var position: Int = 0
        private set

    fun tryMove(carMoved: Int) {
        if (carMoved >= MOVING_CONDITION) {
            position++
        }
    }
}
