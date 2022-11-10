package race

import race.Random.generateRandomNumber

class Race {
    private val THRESHOLD = 4
    fun start(carCount: Int, tryCount: Int): List<Car> {
        var cars = List(carCount) { Car() }
        for (i in 1..tryCount) {
            cars = moveCars(cars)
        }
        return cars
    }

    private fun moveCars(cars: List<Car>): List<Car> =
        cars.map {
            val randomNumber = generateRandomNumber()
            val moveCondition = randomNumber >= THRESHOLD
            it.move(moveCondition)
            it
        }
}
