package racingcar

import racingcar.racing.car.Car
import racingcar.racing.Racing
import racingcar.racing.car.CarName
import racingcar.racing.car.engine.RacingEngine
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputValues = InputView().receiveValues()

    val racing = Racing(
        trials = inputValues.trials,
        cars = generateCars(inputValues.carNames)
    )

    val results = racing.start()

    ResultView().print(results)
}

private fun generateCars(carNames: List<String>): List<Car> {
    return carNames.map { Car(CarName(it), RacingEngine()) }
}
