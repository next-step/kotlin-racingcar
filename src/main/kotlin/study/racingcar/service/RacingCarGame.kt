package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.domain.Cars
import study.racingcar.domain.RaceResults
import study.racingcar.domain.Winners
import study.racingcar.util.RacingCarRandomGenerator

class RacingCarGame(
    private val carNames: List<String>
) {
    fun start(tryCount: Int): RaceResults {
        val carList: List<Car> = carNames.map { Car(it) }
        var cars = Cars(carList)
        val raceResults: MutableList<Cars> = mutableListOf()
        (0 until tryCount).forEach { _ ->
            cars.moveCars()
            raceResults.add(Cars(cars.racedCars))
        }
        return RaceResults(raceResultCars = raceResults.toList())
    }

    private fun race(cars: List<Car>): Cars {
        cars.forEach { it.move(RacingCarRandomGenerator.random()) }
        return Cars(racedCars = cars)
    }
}
