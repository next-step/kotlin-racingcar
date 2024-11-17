package racingcar.domain

import racingcar.domain.vo.CarPosition
import racingcar.domain.vo.GameWinners
import racingcar.domain.vo.Round

class RacingGame(
    nameInput: String,
    inputRoundCount: Int,
    private val numberGenerator: NumberGenerator,
) {
    private val cars: Cars = Cars.makeNewCars(nameInput)
    private var round = Round(inputRoundCount)
    private val carsMovementTracker = cars.makeCarsMovementTracker()

    fun play() {
        round = round.decrease()
        cars.move(numberGenerator)
        cars.recordPositions(carsMovementTracker)
    }

    fun isEnd(): Boolean {
        return round.isZero()
    }

    fun extractRaceHistory(): LinkedHashMap<Car, List<CarPosition>> {
        return carsMovementTracker.getCarsPositionHistories()
    }

    fun extractCarNames(): List<String> {
        return cars.getCarNames()
    }

    fun extractNowCarPositions(): List<Int> {
        return cars.getPositionValues()
    }

    fun getWinnerNames(): List<String> {
        return GameWinners(cars).names
    }
}
