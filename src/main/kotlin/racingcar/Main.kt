package racingcar

import racingcar.domain.RacingGame
import racingcar.view.printRacingGameResult
import racingcar.view.readCarNames
import racingcar.view.readTryCount

fun main() {
    val carNames = readCarNames()
    val tryCount = readTryCount()
    val racingGame = RacingGame(carNames, tryCount)
    val racingGameResults = racingGame.run()
    printRacingGameResult(racingGameResults)
}
