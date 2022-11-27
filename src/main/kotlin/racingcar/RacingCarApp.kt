package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.ui.InputView.printInputRacingCarName
import racingcar.ui.InputView.printInputRacingCount
import racingcar.ui.ResultView.printResult

private const val TERMS_NAME_SPLIT = ","

fun main() {
    printInputRacingCarName()

    val racingCarNames = readLine()?.split(TERMS_NAME_SPLIT) ?: emptyList()

    val racingGame = RacingGame.create(racingCarNames.map { Car(it) })

    printInputRacingCount()

    val racingCount = readLine()?.toInt() ?: 0

    printResult(racingGame, racingCount)
}

