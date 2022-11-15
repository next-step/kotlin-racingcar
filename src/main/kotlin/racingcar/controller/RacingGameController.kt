package racingcar.controller

import racingcar.domain.racing_game.CompeteRacingGame
import racingcar.domain.racing_game.RacingGame
import racingcar.ui.ResultView

class RacingGameController(
    private val racingGame: RacingGame
) {
    fun doRacingGame(executeNum: Int) {
        ResultView.printIntro()
        repeat(executeNum) {
            racingGame.race()
            ResultView.printResult(racingGame.cars)
        }
        if (racingGame is CompeteRacingGame) {
            ResultView.printWinner(racingGame.getWinner())
        }
    }
}
