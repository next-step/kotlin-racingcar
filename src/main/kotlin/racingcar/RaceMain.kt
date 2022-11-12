package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {

    val carNames = InputView.inputCarNames()
    val roundCount = InputView.inputRacingFullRound()

    var raceStage = RaceStage.create(carNames)

    ResultView.printResultIntroWording()

    repeat(roundCount) {
        raceStage = raceStage.racing()
        ResultView.printResult(raceStage)
    }

    ResultView.printWinner(raceStage)
}
