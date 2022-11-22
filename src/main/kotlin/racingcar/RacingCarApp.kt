package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.ui.InputView.printInputRacingCarName
import racingcar.ui.InputView.printInputRacingCount
import racingcar.ui.ResultView.printResult

fun main() {
    printInputRacingCarName()

    val racingCarNames = readLine()?.split(",") ?: emptyList()

    val racingGame = RacingGame.create(racingCarNames)

    printInputRacingCount()

    val racingCount = readLine()?.toInt() ?: 0

    printResult(racingGame, racingCount)
}

