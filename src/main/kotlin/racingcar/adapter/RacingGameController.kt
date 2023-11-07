package racingcar.adapter

import racingcar.application.RacingGame
import racingcar.application.RacingGameUseCase
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.InputViewImpl
import racingcar.view.ResultView
import racingcar.view.ResultViewImpl

class RacingGameController(
    private val racingGame: RacingGameUseCase = RacingGame(),
    private val inputView: InputView = InputViewImpl(),
    private val resultView: ResultView = ResultViewImpl(),
) {
    fun start() {
        // Input
        val carNameList = inputView.inputCarNameList()
        val tryCount = inputView.inputTryCount()

        // Create cars
        val cars = racingGame.createCars(carNameList)

        // Print start description
        resultView.printResultStart()

        // Run & Print result
        runAndPrintResult(cars, tryCount)

        // Print winners
        resultView.printWinners(racingGame.getWinners(cars))
    }

    private fun runAndPrintResult(cars: Cars, tryCount: Int = 1) {
        for (i in 1..tryCount) {
            racingGame.run(cars)
            printResult(cars)
        }
    }

    private fun printResult(cars: Cars) {
        resultView.printResult(cars.getCars().map { CarDto.from(it) })
    }
}
