package racingcar

import racingcar.car.Car
import racingcar.move.Move
import racingcar.move.RandomMove
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCar(
    val carNumber: Int,
    val tryNumber: Int,
    val move: Move = RandomMove(),
) {
    val cars = MutableList(carNumber) { Car(Car.MoveHistory(tryNumber), move) }
    fun start(): MutableList<Car> {
        repeat(tryNumber) {
            cars.forEach {
                it.move()
            }
        }

        return cars
    }
}

fun main() {
    val (carNumber, tryNumber) = InputView.askCarRacingInfo()
    val cars = RacingCar(carNumber, tryNumber).start()
    ResultView.drawHistory(tryNumber, cars)
}
