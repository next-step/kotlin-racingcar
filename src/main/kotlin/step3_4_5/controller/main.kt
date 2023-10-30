package step3_4_5.controller

import step3_4_5.domain.racing.Car
import step3_4_5.domain.racing.CarRacing
import step3_4_5.view.InputView
import step3_4_5.view.OutputView
import step3_4_5.view.ResultView

fun main() {
    OutputView.printEnterNumberOfCarsMessage()
    val numberOfCars = InputView.processEnteredCarInformation()

    OutputView.printEnterNumberOfRoundMessage()
    val numberOfRounds = InputView.processEnteredNumberOfRounds()

    val carList = numberOfCars.map { Car(it) }
    val racing = CarRacing(carList, numberOfRounds)

    racing.doRacing { result ->
        ResultView.showResult(result)
    }
    ResultView.showLastResult(carList)
}
