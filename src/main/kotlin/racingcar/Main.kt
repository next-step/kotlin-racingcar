package racingcar

import racingcar.domain.Game
import racingcar.view.printGameResult
import racingcar.view.readCarNames
import racingcar.view.readTryCount

fun main() {
    val carNames = readCarNames()
    val tryCount = readTryCount()
    val game = Game(carNames, tryCount)
    val gameResults = game.run()
    printGameResult(gameResults)
}
