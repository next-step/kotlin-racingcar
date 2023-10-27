import racingcar.InputView.inputHowManyCar
import racingcar.InputView.inputOperationCar
import racingcar.Operation
import racingcar.ResultView

fun main() {
    val carCount = inputHowManyCar()
    val operationCount = inputOperationCar()

    var cars = Operation.initCar(carCount)

    println("실행 결과")
    repeat(operationCount) {
        cars = Operation.moveCar(cars)
        ResultView.printResult(cars)
    }
}
