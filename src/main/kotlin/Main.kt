import racingcar.Cars
import racingcar.InputView.inputOperationCar
import racingcar.InputView.inputRacingCar
import racingcar.ResultView.printResult

fun main() {
    val carNames = inputRacingCar()
    val operationCount = inputOperationCar()

    val cars = Cars(carNames)
    printResult(cars, operationCount)
}
