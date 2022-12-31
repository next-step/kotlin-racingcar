package racingcar

import racingcar.common.InputValidation
import racingcar.domain.Racing
import racingcar.entity.Car
import view.InputView
import view.OutputView

val inputView = InputView()
val outputView = OutputView()
val inputValidation = InputValidation()
val racing = Racing()
fun main() {

    val namedCars = inputValidation.namedCarValidation(inputView.inputNamedCar())
    val carTrial = inputValidation.validate(inputView.inputCountTrial())
    val cars = racing.makeCars(namedCars)
    outputView.printResultMsg()
    executeResult(carTrial, cars)
    val winingCars = racing.findWinner(cars)
    outputView.printWiningCars(winingCars)
}

private fun executeResult(trial: Int, cars: List<Car>) {
    (1..trial).forEach { _ ->
        cars.apply {
            racing.moveCars(this)
            outputView.printCars(this)
        }
    }
}
