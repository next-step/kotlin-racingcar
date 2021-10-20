package racing

class Game(
    private val roundCount: Int,
    private val carCount: Int,
    private val canMoveForward: Random,
    private val movingCondition: Int
) {
    companion object {
        fun isPositive(value: Int) {
            require(value > 0) { "양수만 가능합니다." }
        }
    }

    init {
        isPositive(roundCount)
        isPositive(carCount)
    }

    fun start() {
        val cars = List(carCount) { Car(canMoveForward, movingCondition) }

        OutPutView.printStart()
        for (i in 0..roundCount) {
            cars.forEach(Car::moveForward)
            OutPutView.printRound(cars)
        }
    }
}
