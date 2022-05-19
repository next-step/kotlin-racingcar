package step4.racingcar.racingcar

object CarRacing {
    fun execute(racers: List<String>, moveCount: Int): List<Car> {
        val car = racers.map { Car(it) }
        repeat(moveCount) {
            executeCarRacing(car)
        }
        return car
    }

    fun getWinner(cars: List<Car>): List<Car> {
        val maxCount = cars.maxOf { car -> car.movements.count { it } }
        return cars.filter { car -> car.movements.count { it } == maxCount }
    }

    private fun executeCarRacing(carList: List<Car>) {
        carList.forEach {
            val random = generateRandomNumber()
            it.moveOrStop(random)
        }
    }

    private fun generateRandomNumber() = RANDOM_RANGE.random()
    private val RANDOM_RANGE = (0..9)
}
