package game.racing

import game.racing.controller.RacingGameController
import game.racing.domain.CarFactory
import game.racing.domain.RacingGame
import game.racing.domain.RacingManager
import game.racing.view.InputView

fun main() {
    val cars = CarFactory.generateCarByCarNames(InputView.inputCarNames())
    val racingManager = RacingManager(cars)
    val racingGame = RacingGame(racingManager)

    val resultList = RacingGameController.progressGame(racingGame, InputView.inputTryNumber())
    RacingGameController.showGameResult(resultList, racingManager.determineWinner())
}
