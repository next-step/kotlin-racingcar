package carracing

import carracing.view.InputView
import carracing.view.OutputView

fun main() {

    val carNames = InputView.inputCarNames()
    val attemptCount = InputView.getAttemptCount()
    OutputView.racingResult(carNames, attemptCount)
}
