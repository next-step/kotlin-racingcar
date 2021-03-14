package racingcar

import racingcar.domain.racing.Racing
import racingcar.domain.car.CarName
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputValues = InputView().receiveValues()

    val racing = Racing(
        trials = inputValues.trials,
        carNames = inputValues.carNames.map { CarName(it) }
    )

    val results = racing.start()

    ResultView().print(results)
}
