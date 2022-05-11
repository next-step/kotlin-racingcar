package carRacing

class Game(
    numCar: Int,
    private val numMovement: Int,
) {

    var recordList: List<List<Int>> = listOf()
        private set

    private val cars: List<Car> = (1..numCar).map { Car() }

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
