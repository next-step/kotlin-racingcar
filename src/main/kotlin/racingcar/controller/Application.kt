package racingcar.controller

import racingcar.domain.GameInfo
import racingcar.domain.RacingCarGame
import racingcar.ui.InputView

fun main() {
    val gameInfo = GameInfo(
        carInfo = InputView.getCarInfo(),
        trialCount = InputView.getTrialCount()
    )

    RacingCarGame(gameInfo = gameInfo).start()
}
