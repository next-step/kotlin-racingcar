package step3_4

import step3_4.racing.Car
import step3_4.racing.CarRacing
import step3_4.view.InputView
import step3_4.view.OutputView
import step3_4.view.ResultView

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
