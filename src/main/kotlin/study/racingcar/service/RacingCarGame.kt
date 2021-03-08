package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.domain.RaceResult
import study.racingcar.domain.Winners
import study.racingcar.util.RacingCarRandomGenerator

class RacingCarGame(
    private val carNames: List<String> = listOf(),
    private val tryCount: Int = 0,
    private val cars: List<Car> = carNames.map { Car(it) }
) {
    var raceResults: List<RaceResult> = ArrayList()
        private set
    var winners: Winners = Winners(listOf())
        private set

    fun start() {
        this.raceResults = (0 until tryCount).map { race(this.cars) }
        this.winners = Winners(racedCars = this.cars)
    }

    private fun race(cars: List<Car>): RaceResult {
        cars.forEach { it.move(RacingCarRandomGenerator.random()) }
        return RaceResult(racedCars = cars)
    }
}
