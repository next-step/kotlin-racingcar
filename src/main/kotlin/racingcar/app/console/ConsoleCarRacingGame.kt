package racingcar.app.console

import racingcar.domain.CarRacingGame
import racingcar.domain.RandomMoveStrategy

fun main() {

    val inputView = InputView()
    val outputView = OutputView()

    val carCount = inputView.inputCar()
    val round = inputView.inputRound()

    val carRacingGame = CarRacingGame(carCount, round, RandomMoveStrategy())

    outputView.writeMessage("실행 결과")
    while (carRacingGame.hasNextRound()) {
        carRacingGame.runRound()
        outputView.writeCars(carRacingGame.cars)
        if (carRacingGame.hasNextRound()) outputView.writeLineBreak()
    }
}
