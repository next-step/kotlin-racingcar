package racingcar

import racingcar.domain.ForwardStrategy
import racingcar.domain.RacingCar
import racingcar.view.InputView
import racingcar.view.ResultView

class Controller(private val inputView: InputView, private val resultView: ResultView) {

    fun getCarNames(): String = inputView.inputCarNames()

    fun getTryCount(): Int = inputView.inputTryCount()

    fun startRacing(inputCarNames: String, tryCount: Int) {
        val racingCar = RacingCar(inputCarNames, tryCount)
        val moveHistory = racingCar.start(ForwardStrategy.DefaultForward)
        val historyData = moveHistory.moveHistory

        printRacing(historyData.keys.toList(), historyData, tryCount)
        printResult(moveHistory.getWinningCarNames())
    }

    private fun printRacing(carNames: List<String>, moveHistory: Map<String, List<Int>>, tryCount: Int) {
        for (i in 0 until tryCount) {
            carNames.forEach { carName ->
                resultView.printCarName(carName)
                resultView.printCarMove(moveHistory[carName]!![i])
            }
            resultView.printLineSpacing()
        }
    }

    private fun printResult(winningCarNames: List<String>) {
        resultView.printWinningCars(winningCarNames)
    }
}
