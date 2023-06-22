package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.CarsGenerator
import racingcar.domain.RandomMoveStrategy
import racingcar.domain.RoundCount
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarGame(
    private var inputView: InputView = InputView(),
    private var resultView: ResultView = ResultView()
) {

    private val carsGenerator = CarsGenerator(RandomMoveStrategy())

    fun play() {
        val cars = getCars()
        val roundCount = RoundCount(inputView.inputRoundCount())
        repeat(roundCount.count) {
            cars.move()
            printResults(cars)
        }
        val winners = cars.getWinners()
        printWinners(winners)
    }

    private fun printWinners(winners: Cars) {
        resultView.printWinnersName(winners.names)
    }

    private fun printResults(cars: Cars) {
        val result: List<String> = cars.getPathStrings()
        resultView.printResult(result)
    }

    private fun getCars(): Cars {
        val carNames = inputView.inputCarsNames()
        return carsGenerator.generate(carNames)
    }
}
