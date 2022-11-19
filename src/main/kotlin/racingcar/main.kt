package racingcar

import racingcar.application.car.CarRacing
import racingcar.view.InputViewImpl
import racingcar.view.PromptServiceImpl
import racingcar.view.ResultView

fun main() {
    val inputView = InputViewImpl()
    val resultView = ResultView()
    val promptService = PromptServiceImpl(
        inputView = inputView,
        resultView = resultView
    )

    val carRacing = CarRacing(promptService)
    carRacing.run()
}
