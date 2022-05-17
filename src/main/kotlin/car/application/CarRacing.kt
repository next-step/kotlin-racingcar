package car.application

import car.application.dto.RacingInput
import car.application.dto.RacingResult
import car.application.dto.RapResult
import car.application.dto.RapResults
import car.domain.Cars
import car.domain.RandomMovingStrategy

object CarRacing {
    private val movingStrategy = RandomMovingStrategy()

    fun race(racingInput: RacingInput): RacingResult {
        val (carNames, tryCount) = racingInput
        val cars = Cars(carNames)
        return RacingResult(List(tryCount.value) { startRap(cars) }, cars.findWinners().map { it.name })
    }

    private fun startRap(cars: Cars): RapResults {
        return cars.move(movingStrategy)
            .map { RapResult(it.name, it.position) }
            .run { RapResults(this) }
    }
}
