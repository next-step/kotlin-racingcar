package racingcar

fun main() {
    val numberOfCars = InputView.readInputForNumbersOfCars()
    val numberOfTry = InputView.readInputForNumberOfTry()
    val circuit = createCircuit(numberOfCars)
    printResult(numberOfTry, circuit)
}

fun createCircuit(numberOfCars: Int) = Circuit().apply {
    repeat(numberOfCars) {
        addCarToCircuit(Car(4))
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
