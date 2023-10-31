import racingcar.domain.Cars
import racingcar.view.InputView.inputOperationCar
import racingcar.view.InputView.inputRacingCar
import racingcar.view.ResultView.printResult

fun main() {
    val carNames = inputRacingCar()
    val cars = Cars(carNames)
    val operationCount = inputOperationCar()

    printResult(cars, operationCount)
}
