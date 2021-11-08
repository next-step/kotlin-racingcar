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
        startRacing(racing)
    }
    ResultView.printRacingWinner(racing.getWinner())
}

fun startRacing(racing: Racing) {
    racing.start().forEach { car ->
        ResultView.printRacingResult(car)
    }
    ResultView.printEmptyView()
}
