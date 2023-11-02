package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.RandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val names = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()
    val racingGame = RacingGame(createRandomGenerator(), names)
    val gameResults = racingGame.start(tryCount)
    ResultView.printGameResults(gameResults)
}

private fun createRandomGenerator(): RandomGenerator {
    return RandomGenerator { (0..9).random() }
}
