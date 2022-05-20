package step4.racingcar.racingcar

class CarRacing(private val racers: List<String>, private val moveCount: Int) {
    private val _cars: MutableList<Car> = mutableListOf()

    val gameResult: GameResult
        get() = GameResult(this._cars, moveCount)

    fun execute() {
        this._cars.addAll(racers.map { Car(it) })

        repeat(moveCount) {
            executeCarRacing(_cars)
        }
    }

    fun getWinner(): String {
        val cars = this.gameResult.cars
        val maxCount = cars.maxOf { car -> car.getMovementCount() }
        return cars.filter { car -> car.getMovementCount() == maxCount }.joinToString { it.racerName }
    }

    private fun executeCarRacing(carList: List<Car>) {
        carList.forEach {
            val random = generateRandomNumber()
            it.move(random)
        }
    }

    private fun generateRandomNumber() = RANDOM_RANGE.random()
    private val RANDOM_RANGE = (0..9)
}

data class GameResult(
    val cars: List<Car>,
    val round: Int
)