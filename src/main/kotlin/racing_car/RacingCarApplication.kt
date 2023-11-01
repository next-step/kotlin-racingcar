package racing_car

import racing_car.domain.Car
import racing_car.view.InputView
import racing_car.view.ResultView

fun main() {

    // 자동차 대수는 몇 대인가요??
    val numberOfCar = InputView.inputNumberOfCars()
    val cars = List(numberOfCar) { Car() }

    // 시도할 횟수는 몇 회인가요???
    val numberOfRounds = InputView.inputNumberOfRounds()

    // 실행 결과
    ResultView.printResultTitle()
    for (i in 1..numberOfRounds) {
        cars.forEach { it.move() }
        ResultView.printPosition(cars)
    }
}
