package step4.racingcar.racingcar

class CarRacing(racers: List<String>, private val moveCount: Int) {

    private val car = racers.map { Car(it) }

    val gameResult: GameResult
        get() = GameResult(car, moveCount)

    fun execute() {
        repeat(moveCount) {
            executeCarRacing(car)
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

    companion object {
        private val RANDOM_RANGE = (0..9)
    }
}
