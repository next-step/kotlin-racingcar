package racingcar

fun main() {
    val carsNameList = InputView.readInputForCarsNameList()
    val numberOfTry = InputView.readInputForNumberOfTry()
    val circuit = createCircuit(carsNameList)
    printResult(numberOfTry, circuit)
    val winnerNameList = Race.getWinnerNameList(circuit)
    ResultView.printWinners(winnerNameList)
}

fun createCircuit(carsNameList: List<String>) = Circuit().apply {
    carsNameList.forEach {
        addCarToCircuit(Car(4, it))
    }
}

fun printResult(numberOfTry: Int, circuit: Circuit) {
    ResultView.printProcessResultTitle()
    repeat(numberOfTry) {
        Race.startLap(circuit)
        val lapResult = circuit.getAllCarsLapResult()
        ResultView.printResult(lapResult)
    }
}
