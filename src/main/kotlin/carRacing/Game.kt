package carRacing

class Game(
    numCar: Int,
    private val numMovement: Int,
) {

    init {
        require(numCar >= 1) { INVALID_CAR_NUMBER }
        require(numMovement >= 1) { INVALID_NUM_MOVEMENT }
    }

    var recordList: List<Record> = listOf()
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
            Record(this.cars.map { it.position })
        }
    }

    companion object {
        private const val MOVE_ACTION_MIN = 4
        const val INVALID_CAR_NUMBER = "자동차 수는 1이상 이어야한다."
        const val INVALID_NUM_MOVEMENT = "시도 횟수는 1이상 이어야한다."
    }
}
