package racing.domain

class Cars(
    val roundInfo: List<Car>,
    private val moveStrategy: CarMoveStrategy
) {

    fun tryMoveCars() {
        roundInfo.forEach {
            car ->
            if (moveStrategy.isMovable()) car.move()
        }
    }

    fun winner(): List<Car> {
        val maxPosition = roundInfo.maxOf { it.position.value }
        return roundInfo.filter { it.position.value == maxPosition }
    }
}
