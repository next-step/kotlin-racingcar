package racing

import racing.domain.CarRacing
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val numOfCars = InputView.inputNumOfCars()
    val numOfMove = InputView.inputNumOfMove()

    val carRacing = CarRacing(numOfCars)

    ResultView.printResultTitle()
    for (i in 1..numOfMove) {
        carRacing.move()
        ResultView.printResult(carRacing)
    }
}
