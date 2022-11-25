package racingcar

import racingcar.domain.RacingCarGame
import racingcar.domain.model.GameInfo
import racingcar.ui.InputView

fun main() {
    val gameInfo = GameInfo(
        carInfo = InputView.getCarInfo(),
        trialCount = InputView.getTrialCount()
    )

    RacingCarGame(gameInfo = gameInfo).start()
}
