package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.RandomGameRule
import racingcar.view.InputView
import racingcar.view.ResultView

fun main(args: Array<String>) {
    val racingCars = InputView.readRacingCars()
    val gameRound = InputView.readGameRound()

    val racingCarGame = RacingGame(
        gameRule = RandomGameRule,
        gameRound = gameRound,
        cars = racingCars
    )

    ResultView.writeResultTitle()
    while (racingCarGame.hasNextRound()) {
        racingCarGame.nextRound()
        ResultView.writeCarPosition(racingCarGame.cars)
    }
}
