import racingcar.Cars
import racingcar.InputView.inputHowManyCar
import racingcar.InputView.inputOperationCar
import racingcar.ResultView.printResult

fun main() {
    val carCount = inputHowManyCar()
    val operationCount = inputOperationCar()

    val cars = Cars(carCount)
    println("실행 결과")
    repeat(operationCount) {
        cars.operateCars()
        printResult(cars.carList)
    }
}
