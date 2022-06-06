package racingcar.domain

import racingcar.domain.car.Cars
import racingcar.domain.car.Name

class RacingGame(
    private var cars: Cars,
    private var tryNumber: TryNumber,
) {
    fun play(movementStrategy: () -> Int): RacingResult {
        val results = mutableListOf<RacingRecord>()
        while (tryNumber.isPlaying) {
            cars = cars.moveAll(movementStrategy)
                .also { results.add(it.toRacingResult()) }
            tryNumber = tryNumber.consume()
        }

        return RacingResult(results.toList())
    }

    fun getWinners(): List<Name> {
        return cars.findAllEqualPositionTo(cars.maxPosition)
    }
}

private fun Cars.toRacingResult(): RacingRecord = RacingRecord(this.cars)
