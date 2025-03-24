package racingcar

import racingcar.game.RacingGame
import racingcar.view.CarDto
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputCarNames = InputView.requestCarNames()
    val inputNumberOfRounds = InputView.requestNumberOfRounds()

    val racingGame = RacingGame(inputCarNames, inputNumberOfRounds)

    while (racingGame.playable) {
        racingGame.play()

        val cars = racingGame.cars.values.map { CarDto(it.position, it.name) }
        OutputView.printCarStatus(cars)
    }

    OutputView.printWinners(racingGame.cars.winningCarNames())
}
