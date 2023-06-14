package racingcar

import racingcar.domain.RacingGameParam
import racingcar.io.InputView
import racingcar.racing.RacingGame

fun main() {
    val carNameList = InputView.getCarNames()
    val rounds = InputView.getRoundCount()

    val gameParam = RacingGameParam(carNameList, rounds)
    RacingGame(gameParam).start()
}
