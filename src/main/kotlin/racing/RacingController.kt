package racing

import racing.domain.RacingGame
import racing.domain.RacingMovingRule
import racing.ui.InputView
import racing.ui.ResultView

object RacingController {
    fun startRacing() {
        val cars = InputView.getCars()
        val movingCount = InputView.getMoveCount()
        val racingGame = RacingGame(cars, RacingMovingRule(movingCount))
        val racing = racingGame.goRacing()
        ResultView.getRacingResult(racing, cars)
    }
}
