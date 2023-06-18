package racingcar.app.console

import racingcar.domain.CarRacingGame
import racingcar.domain.RandomMoveStrategy

fun main() {

    val inputView = InputView()
    val outputView = OutputView()

    val catNames = inputView.inputCarNames()
    val round = inputView.inputRound()

    val carRacingGame = CarRacingGame(catNames, round, RandomMoveStrategy())

    outputView.writeMessage("실행 결과")
    carRacingGame.race { outputView.writeCars(it) }
}
