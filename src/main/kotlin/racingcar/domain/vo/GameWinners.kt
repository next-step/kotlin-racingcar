package racingcar.domain.vo

import racingcar.domain.Cars

@JvmInline
value class GameWinners(val names: List<String>) {
    constructor(cars: Cars) : this(extractWinnersFromCars(cars))

    companion object {
        private fun extractWinnersFromCars(cars: Cars): List<String> {
            val positionValues = cars.getPositionValues()
            val maxPosition = positionValues.max()
            val carNames = cars.getCarNames()
            return carNames.filterIndexed { index, _ ->
                positionValues[index] == maxPosition
            }
        }
    }
}
