package week1.racingcar

import kotlin.random.Random

class RacingGame {

    fun start() {
        InputView().startInput().also { result ->
            val cars = result.cars.map { Car(it) }
            val timesToRace = result.timesToRace
            race(cars, timesToRace)
        }
    }

    private fun race(cars: List<Car>, timesToRace: Int) {
        val resultView = ResultView()
        repeat(timesToRace) {
            drive(cars)
            showResult(resultView, cars)
        }
    }

    private fun drive(cars: List<Car>) {
        cars.forEach {
            if (isPossibleToDrive()) it.go()
        }
    }

    private fun showResult(resultView: ResultView, cars: List<Car>) {
        resultView.run {
            showResult(cars)
            showWinner(getWinners(cars))
        }
    }

    private fun isPossibleToDrive() = Random.nextInt(COUNT_OF_DIGITS) >= MIN_NUM_TO_GO

    private fun getWinners(cars: List<Car>): List<String> {
        val farthestMileage = getFarthestMileage(cars)
        return cars.filter { it.mileage == farthestMileage }.map { it.name }
    }

    private fun getFarthestMileage(cars: List<Car>): Int {
        return cars.map { it.mileage }.maxOf { it }
    }

    companion object {
        private const val MIN_NUM_TO_GO = 5
        private const val COUNT_OF_DIGITS = 10
    }
}

fun main() {
    RacingGame().start()
}