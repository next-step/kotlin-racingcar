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
    val numberOfCars = InputView.enteredCarInformation()

    OutputView.printEnterNumberOfRoundMessage()
    val numberOfRounds = InputView.enteredNumberOfRounds()

    for (name in numberOfCars) {
        carList.add(Car(carName = name))
    }

    racing.doRacing(numberOfRounds, carList) { result ->
        ResultView.showResult(result)
    }
}
