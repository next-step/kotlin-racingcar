package step3

import step3.domain.RacingSimulator
import step3.view.InputView
import step3.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val racingSimulator = RacingSimulator()

    val racingRequest = inputView.inputRacingInfo()
    val racingRecord = racingSimulator.race(racingRequest)
    resultView.outputRacingResult(racingRecord)
}
