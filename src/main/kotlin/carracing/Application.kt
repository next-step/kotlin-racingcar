package carracing

import carracing.ui.InputView
import carracing.ui.OutputView

fun main() {

    val carNames = InputView.inputCarNames()
    val attemptCount = InputView.getAttemptCount()
    OutputView.racingResult(carNames, attemptCount)
}
