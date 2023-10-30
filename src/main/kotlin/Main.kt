import racingcar.Cars
import racingcar.InputView.inputOperationCar
import racingcar.InputView.inputRacingCar
import racingcar.ResultView.printResult

fun main() {
    val carNames = inputRacingCar()
    val cars = Cars(carNames)
    val operationCount = inputOperationCar()

    printResult(cars, operationCount)
}
