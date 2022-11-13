package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.racing_game.RacingGameFactory
import racingcar.model.GameMode
import racingcar.ui.InputView

fun main() {
    val racingGame = RacingGameFactory().create(GameMode.COMPETE)
    val racingGameController = RacingGameController(racingGame)
    racingGameController.doRacingGame(executeNum = InputView.requestExecuteNum())
}
