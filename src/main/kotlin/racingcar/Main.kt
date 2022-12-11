package racingcar

import racingcar.domain.FormularOne
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    inputView.show()

    val f1 = FormularOne()
    f1.start(carNames = inputView.carNames, numberOfGame = inputView.numberOfGame)

    ResultView.show(f1)
}
