package carRacing

class Game(
    numCar: Int,
    private val numMovement: Int,
) {

    init {
        require(numCar >= 1) { throw IllegalArgumentException("자동차 수는 1이상 이어야한다.") }
        require(numMovement >= 1) { throw IllegalArgumentException("시도 횟수는 1이상 이어야한다.") }
    }

        private set

    private val cars: List<Car> = List(numCar) { Car() }

    private fun runRound() {
        this.cars.forEach {
            val randomValue: Int = RandomGenerator.value()
            if (randomValue >= MOVE_ACTION_MIN) it.move()
        }
    }

    fun run() {
        this.recordList = (1..this.numMovement).map {
            this.runRound()
            this.cars.map { it.position }
        }
    }

    companion object {
        private const val MOVE_ACTION_MIN = 4
    }
}
