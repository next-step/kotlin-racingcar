package racing

import racing.domain.CarRacing
import racing.domain.RandomMoveStrategy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val numOfCars = InputView.inputNumOfCars()
    val numOfMove = InputView.inputNumOfMove()

    val carRacing = CarRacing(numOfCars, RandomMoveStrategy())

    ResultView.printResultTitle()
    for (i in 1..numOfMove) {
        carRacing.move()
        ResultView.printResult(carRacing)
    }
}
