package racingcar

import racingcar.domain.racing.Racing
import racingcar.util.Validation
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carsName = InputView.getCarsName().also {
        Validation.checkNameCountCondition(it)
    }
    val attemptCount = InputView.getAttemptCount().also {
        Validation.checkTryCountCondition(it)
    }
    val racing = Racing(carsName)
    repeat(attemptCount.toInt()) {
        ResultView.printRacingResult(racing.start())
    }
    ResultView.printRacingWinner(racing.getWinner())
}
