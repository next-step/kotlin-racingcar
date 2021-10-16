package racingcar.mock

import racingcar.model.Cars
import racingcar.model.RacingCarGameResult
import racingcar.view.OutputView

class NoOutputView : OutputView {

    override fun showGameStart() = Unit
    override fun showGameRoundStart(round: Int, cars: Cars) = Unit
    override fun showGameRoundEnd(round: Int, cars: Cars) = Unit
    override fun showGameResult(result: RacingCarGameResult) = Unit
}
