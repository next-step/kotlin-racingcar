package step3

import step3.racing.Car
import step3.racing.CarRacing
import step3.view.InputView
import step3.view.OutputView
import step3.view.ResultView

fun main() {
    val carList = mutableListOf<Car>()
    val racing = CarRacing()

    OutputView.printEnterNumberOfCarsMessage()
    val numberOfCars = InputView.enterNumberOfCars()

    OutputView.printEnterNumberOfRoundMessage()
    val numberOfRounds = InputView.enterNumberOfRounds()

    for (i in 1..numberOfCars) {
        carList.add(Car())
    }

    racing.doRacing(numberOfRounds, carList) { result ->
        ResultView.showResult(result)
    }
}
