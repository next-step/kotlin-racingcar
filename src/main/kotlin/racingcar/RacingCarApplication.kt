package racingcar

import racingcar.controller.RacingCarGame
import racingcar.strategy.RandomNumberGeneratorStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val gameCondition = InputView.getUserInput()
    val racingCarGame = RacingCarGame(gameCondition, RandomNumberGeneratorStrategy())
    val allScore = racingCarGame.startGame()
    ResultView.printResult(allScore)
}
