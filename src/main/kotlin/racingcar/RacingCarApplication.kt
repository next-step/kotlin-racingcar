package racingcar

import racingcar.domain.RacingCar
import racingcar.domain.RacingGame
import racingcar.domain.RandomGameRule
import racingcar.view.InputView
import racingcar.view.ResultView

fun main(args: Array<String>) {
    val nicknames = InputView.readNicknames()
    val totalRound = InputView.readTotalRound()

    val racingCarGame = RacingGame(
        gameRule = RandomGameRule,
        totalRound = totalRound,
        cars = nicknames.map { RacingCar(it) }
    )

    racingCarGame.start()

    ResultView.writeRoundResults(racingCarGame.getRoundResults())
}
