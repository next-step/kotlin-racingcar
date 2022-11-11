package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {

    val carCount = InputView.inputCarCount()
    val roundCount = InputView.inputRacingFullRound()

    var raceStage = RaceStage.create(carCount)

    ResultView.printResultIntroWording()

    repeat(roundCount) {
        raceStage = raceStage.racing()
        ResultView.printResult(raceStage)
    }
}
