package racingCar

import racingCar.Entity.Car
import racingCar.common.InputValidation
import racingCar.domain.Racing
import view.InputView
import view.OutputView

val inputView = InputView()
val outputView = OutputView()
val inputValidation = InputValidation()
val racing = Racing()
fun main() {

    val carNum = inputValidation.validate(inputView.inputCountCar())
    val carTrial = inputValidation.validate(inputView.inputCountCar())
    val cars = racing.makeCars(carNum)
    outputView.printResultMsg()
    executeResult(carTrial, cars)
}

private fun executeResult(trial: Int, cars: List<Car>) {
    (1..trial).forEach { _ ->
        cars.apply {
            racing.moveCars(this)
            outputView.printCars(this)
        }
    }
}
