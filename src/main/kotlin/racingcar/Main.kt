package racingcar

import racingcar.controller.RacingCarGame
import racingcar.domain.RaceWinnersExtractor
import racingcar.view.printResult
import racingcar.view.printWinners

fun main() {
    val racingGame = RacingCarGame()
    val history = racingGame.play()
    printResult(history)
    printWinners(RaceWinnersExtractor().extractWinners(history))
}
