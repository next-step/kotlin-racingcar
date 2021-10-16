package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingCarGameResult

interface ResultView {

    fun showGameStart()

    fun showGameRoundStart(round: Int, cars: List<Car>)

    fun showGameRoundEnd(round: Int, cars: List<Car>)

    fun showGameResult(result: RacingCarGameResult)
}
