package game.racing

import game.racing.controller.RacingGameController
import game.racing.domain.CarFactory
import game.racing.domain.RacingManager
import game.racing.view.InputView

fun main() {
    val cars = CarFactory.generateCarByCarNames(InputView.inputCarNames())
    val racingGameController = RacingGameController(RacingManager(cars))
    racingGameController.initializeGame()
    val resultList = racingGameController.tryMovesRepeatedly(InputView.inputTryNumber())
    racingGameController.showGameResult(resultList)
}
