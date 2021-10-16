package racingcar.view

import racingcar.model.Cars
import racingcar.model.RacingCarGameResult

interface ResultView {

    fun showGameStart()

    fun showGameRoundStart(round: Int, cars: Cars)

    fun showGameRoundEnd(round: Int, cars: Cars)

    fun showGameResult(result: RacingCarGameResult)
}
