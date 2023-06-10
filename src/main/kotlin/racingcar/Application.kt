package racingcar

import racingcar.domain.RacingGame.Companion.createRandomMoveCarRacingGame
import racingcar.view.inputAttemptCount
import racingcar.view.inputCarCount
import racingcar.view.printCurrentResult
import racingcar.view.printResultTitle
import racingcar.view.printWinner

fun main() {
    val racingGame = createRandomMoveCarRacingGame(carCount = inputCarCount(), attemptCount = inputAttemptCount())

    printResultTitle()
    while (racingGame.isRunnable()) {
        printCurrentResult(racingGame.run())
    }
    printWinner(racingGame.winner())
}
