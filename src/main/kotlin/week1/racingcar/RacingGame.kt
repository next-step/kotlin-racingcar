package week1.racingcar

class RacingGame {

    private val cars: List<String>
    private val timesToRace: Int

    init {
        InputView.getValidateRaceInfo().also {
            cars = it.cars
            timesToRace = it.timesToRace
        }
    }

    fun startGame() {
        val cars = cars.map { Car(it) }
        race(cars, timesToRace)
    }

    private fun race(cars: List<Car>, timesToRace: Int) {
        repeat(timesToRace) {
            drive(cars)
            showResult(cars)
        }
    }

    private fun drive(cars: List<Car>) {
        cars.forEach {
            it.moveOrNot()
        }
    }

    private fun showResult(cars: List<Car>) {
        ResultView.run {
            showResult(cars)
            showWinner(getWinners(cars))
        }
    }

    private fun getWinners(cars: List<Car>): List<String> {
        val farthestMileage = cars.map { it.mileage }
            .maxOf { it }
        return cars.filter { it.isSameMileage(farthestMileage) }
            .map { it.name }
    }
}

fun main() {
    RacingGame().startGame()
}
