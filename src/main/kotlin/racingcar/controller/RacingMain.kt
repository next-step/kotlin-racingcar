package racingcar

import racingcar.domain.Race.startRace
import racingcar.domain.Car
import racingcar.domain.Circuit
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    ResultView.printAskHowManyCars()
    val carsNameList = InputView.readInputForCarsNameList()
    ResultView.printAskHowManyTry()
    val numberOfTry = InputView.readInputForNumberOfTry()

    val circuit = createCircuit(carsNameList)
    ResultView.printProcessResultTitle()
    startRace(circuit, numberOfTry)

    val winnerNameList = Race.getWinnerNameList(circuit)
    ResultView.printWinners(winnerNameList)
}

fun createCircuit(carsNameList: List<String>) = Circuit().apply {
    carsNameList.forEach {
        addCarToCircuit(Car(4, it))
    }
}
