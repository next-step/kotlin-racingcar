package racingcar

import racingcar.racing.Racing
import racingcar.racing.RacingCarGenerator
import racingcar.racing.car.CarName
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputValues = InputView().receiveValues()

    val racing = Racing(
        trials = inputValues.trials,
        carNames = inputValues.carNames.map { CarName(it) },
        carGenerator = RacingCarGenerator.STANDARD
    )

    val results = racing.start()

    ResultView().print(results)
}
