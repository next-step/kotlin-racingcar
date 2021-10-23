package racingcar

import racingcar.Race.startRace

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
