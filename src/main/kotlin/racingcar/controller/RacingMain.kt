package racingcar.controller

import racingcar.domain.Race.startRace
import racingcar.domain.Circuit
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    ResultView.printAskHowManyCars()
    val carsNameList = InputView.readInputForCarsNameList()
    ResultView.printAskHowManyTry()
    val numberOfTry = InputView.readInputForNumberOfTry()

    val circuit = Circuit(carsNameList)
    ResultView.printProcessResultTitle()
    startRace(circuit, numberOfTry) {
        ResultView.printResult(it)
    }

    val winnerNameList = Race.getWinnerNameList(circuit)
    ResultView.printWinners(winnerNameList)
}
