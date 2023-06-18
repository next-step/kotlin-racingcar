package racingcar.game

import racingcar.car.Cars
import racingcar.car.MoveStrategy
import racingcar.car.RoundCount
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarGame(
    private val moveStrategy: MoveStrategy,
    private var inputView: InputView = InputView(),
    private var resultView: ResultView = ResultView()
) {

    private lateinit var cars: Cars

    fun play() {
        getCars()
        val roundCount = RoundCount(inputView.inputCarsCount())
        repeat(roundCount.value()) {
            cars.move()
            printResult()
        }
    }

    private fun printResult() {
        val result: List<String> = cars.getPathStrings()
        resultView.printResult(result)
    }

    private fun getCars() {
        val carCounts = inputView.inputCarsCount()
        cars = Cars(moveStrategy, carCounts)
    }
}
