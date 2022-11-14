package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.ui.InputView.printInputRacingCarCount
import racingcar.ui.InputView.printInputRacingCount
import racingcar.ui.ResultView.printResult

fun main() {
    printInputRacingCarCount()

    val racingCarCount = readLine()?.toInt() ?: 0

    val racingGame = RacingGame.create(racingCarCount)

    printInputRacingCount()

    val racingCount = readLine()?.toInt() ?: 0

    printResult(racingGame, racingCount)
}

