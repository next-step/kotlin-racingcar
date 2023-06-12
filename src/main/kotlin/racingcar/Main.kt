package racingcar

import racingcar.io.InputView
import racingcar.racing.RacingGame

fun main() {
    val gamaParam = InputView().getGameParam()
    RacingGame(gamaParam).start()
}
