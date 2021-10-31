package racingcar

import racingcar.racing.Racing
import racingcar.ui.InputView
import racingcar.util.Validation

fun main() {
    val carsName = InputView.getCarsName().also {
        Validation.checkNameCountCondition(it)
    }
    val attemptCount = InputView.getAttemptCount().also {
        Validation.checkTryCountCondition(it)
    }

    Racing(carsName, attemptCount.toInt()).start()
}
