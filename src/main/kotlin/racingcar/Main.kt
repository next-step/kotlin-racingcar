package racingcar

import racingcar.racing.Racing
import racingcar.ui.InputView

fun main() {
    val carCount = InputView.getCarCount()
    val attemptCount = InputView.getAttemptCount()

    Racing(carCount, attemptCount).start()
}
