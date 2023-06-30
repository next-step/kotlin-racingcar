package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.CarsGenerator
import racingcar.domain.RaceHistory
import racingcar.domain.RandomMoveStrategy
import racingcar.domain.RoundCount
import racingcar.view.InputView

private const val WINNER_NAMES_DELIMITER = ", "

class RacingCarGame(
    private var inputView: InputView = InputView(),
) {

    private val carsGenerator = CarsGenerator(RandomMoveStrategy())

    fun play(): RaceHistory {
        val cars = getCars()
        val roundCount = RoundCount(inputView.inputRoundCount())
        val history = mutableListOf<Cars>()
        repeat(roundCount.count) {
            cars.move()
            history.add(cars)
        }
        return RaceHistory(history)
    }

    private fun getCars(): Cars {
        val carNames = inputView.inputCarsNames()
        return carsGenerator.generate(carNames)
    }
}
