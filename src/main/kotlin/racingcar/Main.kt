package racingcar

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.strategy.RandomMoveStrategy
import racingcar.utils.InputUtils
import racingcar.view.ResultView
import racingcar.view.WinnerView

fun main() {
    val inputDto = InputUtils.askQuestions()

    val racingCarGame = RacingCarGame.ready(inputDto.carNames, RandomMoveStrategy())

    for (i in 1..inputDto.gameCount) {
        val cars: List<Car> = racingCarGame.moveOnce()
        ResultView.printResults(cars)
    }

    val winners: List<Car> = racingCarGame.findWinners()
    WinnerView.printWinner(winners)
}
