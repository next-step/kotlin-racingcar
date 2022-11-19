package racing

import racing.domain.CarRacing
import racing.domain.RandomMoveStrategy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    // val numOfCars = InputView.inputNumOfCars()  // TODO: remove
    val namesOfCars = listOf("car1", "car2", "car3") // TODO : InputView 사용하도록 변경
    val numOfMove = InputView.inputNumOfMove()

    val carRacing = CarRacing(namesOfCars, RandomMoveStrategy())

    ResultView.printResultTitle()
    for (i in 1..numOfMove) {
        carRacing.move()
        ResultView.printResult(carRacing)
    }
}
