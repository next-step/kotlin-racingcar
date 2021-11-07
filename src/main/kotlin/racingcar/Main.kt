package racingcar

import racingcar.domain.car.Car
import racingcar.domain.racing.Racing
import racingcar.view.InputView
import racingcar.util.Validation
import racingcar.view.ResultView

fun main() {
    val carsName = InputView.getCarsName().also {
        Validation.checkNameCountCondition(it)
    }
    val attemptCount = InputView.getAttemptCount().also {
        Validation.checkTryCountCondition(it)
    }
    val showRacingResult = { car: Car ->
        ResultView.printRacingResult(car)
    }
    val showRacingWinner = { winners: List<String> ->
        ResultView.printRacingWinner(winners)
    }
    Racing(carsName, attemptCount.toInt()).start(showRacingResult, showRacingWinner)
}
