package racingcar.game

import racingcar.car.Cars
import racingcar.car.CarsGenerator
import racingcar.car.RandomMoveStrategy
import racingcar.car.RoundCount
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarGame(
    private var inputView: InputView = InputView(),
    private var resultView: ResultView = ResultView()
) {

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
        val carsGenerator = CarsGenerator(carNames, RandomMoveStrategy())
        return carsGenerator.generate()
    }
}
