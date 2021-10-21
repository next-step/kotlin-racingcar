package step3

fun main() {
    val numberOfCars = InputView.readInputForNumbersOfCars()
    val numberOfTry = InputView.readInputForNumberOfTry()
    val circuit = Circuit()
    repeat(numberOfCars) {
        circuit.addCarToCircuit(Car(4))
    }
    ResultView.printProcessResultTitle()
    repeat(numberOfTry) {
        Race.startLap(circuit)
        val lapResult = circuit.getAllCarsMoveDistance()
        ResultView.printResult(lapResult)
    }
}
