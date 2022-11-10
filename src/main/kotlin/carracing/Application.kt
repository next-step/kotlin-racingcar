package carracing

import carracing.ui.InputView
import carracing.ui.OutputView

fun main() {

    val carCount = InputView.getCarCount()
    val attemptCount = InputView.getAttemptCount()
    OutputView.racingResult(carCount, attemptCount)
}

