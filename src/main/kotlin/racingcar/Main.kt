import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    // Input
    val quantity = InputView.inputCarQuantity()
    val tryCount = InputView.inputTryCount()

    // Create cars
    val strategy = RandomMovingStrategy()
    val carList = mutableListOf<Car>()
    for (i in 1..quantity) {
        carList.add(Car(strategy))
    }
    val cars = Cars(carList)

    // Move and print result
    ResultView.moveAndPrintResult(cars, tryCount)
}
