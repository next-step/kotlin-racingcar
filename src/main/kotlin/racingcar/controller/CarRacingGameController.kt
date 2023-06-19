package racingcar.controller

import racingcar.domain.CarRacingGame
import racingcar.domain.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    val inputView = InputView()
    val outputView = OutputView()

    val catNames = inputView.inputCarNames()
    val round = inputView.inputRound()

    val carRacingGame = CarRacingGame(catNames, round, RandomMoveStrategy())

    outputView.writeMessage("실행 결과")
    carRacingGame.race { outputView.writeCars(it) }
}
