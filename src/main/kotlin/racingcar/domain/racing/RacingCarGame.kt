package racingcar.domain.racing

import racingcar.domain.car.CarNames
import racingcar.domain.car.Cars

class RacingCarGame(
    private val originalCars: Cars,
    private val attemptCount: Int
) {

    constructor(
        carNames: CarNames,
        attemptCount: Int
    ) : this(
        originalCars = Cars(carNames.mapToCar()),
        attemptCount = attemptCount
    )

    fun play(): CarsHistory {
        val history = CarsHistory()
        repeat(attemptCount) {
            val racedCars = (history.latest ?: originalCars).race()
            history.add(racedCars)
        }
        return history
    }
}
