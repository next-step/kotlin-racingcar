import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Name
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    // Input
    val carNameList = InputView.inputCarNameList()
    val tryCount = InputView.inputTryCount()

    // Create cars
    val carList = carNameList.map { Car(name = Name(it)) }
    val cars = Cars(carList)

    // Move and print result
    ResultView.printResultStart()
    for (i in 1..tryCount) {
        cars.move()
        ResultView.printResult(cars)
    }
    ResultView.printWinners(cars)
}
