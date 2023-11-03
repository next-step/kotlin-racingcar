package race.domain

import race.view.Output

class RaceManager(cars: List<String>, private val moves: Int) {
    val carList: List<SimpleCar>

    init {
        carList = cars.map { SimpleCar(it) }
    }

    fun start() {
        repeat(moves) {
            carList.forEach { it.move((0..9).random()) }
            Output().printStatus(carList)
        }

        Output().printResult(findWinners())
    }

    fun findWinners(): List<SimpleCar> {
        val max = carList.maxBy { it.location }

        return carList.filter { it.location == max.location }
    }
}
