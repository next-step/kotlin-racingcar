package game.racing

import game.racing.domain.CarFactory
import game.racing.domain.RacingGame
import game.racing.domain.RacingManager
import game.racing.view.InputView
import game.racing.view.ResultView

fun main() {
    val cars = CarFactory.generateCarByCarNames(InputView.inputCarNames())
    val racingManager = RacingManager(cars)
    val racingGame = RacingGame(racingManager)
    val carPositionList = racingGame.tryMovesRepeatedly(InputView.inputTryNumber())
    ResultView.printResults(carPositionList)
    ResultView.printWinner(racingManager.determineWinner())
}
