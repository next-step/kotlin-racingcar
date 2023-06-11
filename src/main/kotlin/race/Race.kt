package race

import race.controller.RaceController
import race.view.ResultData
import race.view.ResultView

class Race(
    private val cars: List<Car>,
    private val numberOfTry: Int
) {
    fun run(): ResultData {
        val records = mutableListOf<List<Car>>()

        repeat(numberOfTry) {
            cars.forEach { it.move() }

            val copiedCars = cars.map { it.copy() }
            records.add(copiedCars)
        }

        return ResultData(records)
    }
}

fun main() {
    val raceRequest = RaceController().run()

    val cars = raceRequest.cars
    val numberOfTry = raceRequest.numberOfTry

    val result = Race(cars, numberOfTry).run()

    ResultView().run(result)
}
