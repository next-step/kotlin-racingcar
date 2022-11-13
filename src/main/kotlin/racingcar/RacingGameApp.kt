package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.racing_game.DefaultRacingGame
import racingcar.domain.random.DefaultRandomGenerator
import racingcar.domain.racing_game.RacingGame
import racingcar.model.Car
import racingcar.model.DefaultCar
import racingcar.ui.InputView

fun main() {
    val racingGameController = setRacingGame()
    racingGameController.doRacingGame(executeNum = InputView.requestExecuteNum())
}

private fun setRacingGame(): RacingGameController {
    val carNum = InputView.requestCarNum()
    val cars = List<Car>(carNum) { DefaultCar() }
    val racingGame: RacingGame = DefaultRacingGame(DefaultRandomGenerator(), cars)
    return RacingGameController(racingGame)
}
