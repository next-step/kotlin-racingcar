package racing

import racing.domain.CarRacing
import racing.domain.RandomMoveStrategy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val namesOfCars = InputView.inputNamesOfCars()
    val numOfMove = InputView.inputNumOfMove()

    val carRacing = CarRacing(numOfMove, namesOfCars, RandomMoveStrategy())

    ResultView.printResultTitle()
    while (!carRacing.finish) {
        carRacing.move()
        ResultView.printResult(carRacing.carInfos)
    }
    ResultView.printWinner(carRacing.electWinners())
}
