import racingcar.Cars
import racingcar.InputView.inputHowManyCar
import racingcar.InputView.inputOperationCar
import racingcar.ResultView.printResult

fun main() {
    val carCount = inputHowManyCar()
    val operationCount = inputOperationCar()

    val cars = Cars(carCount)
    printResult(cars, operationCount)
}
