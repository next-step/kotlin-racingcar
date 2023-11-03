package racingcar

import racingcar.domain.NumberGenerator
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val names = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()
    val racingGame = RacingGame(createRandomNumberGenerator(), names)
    val gameResults = racingGame.start(tryCount)
    ResultView.printGameResults(gameResults)
}

private fun createRandomNumberGenerator(): NumberGenerator {
    return NumberGenerator { (0..9).random() }
}
