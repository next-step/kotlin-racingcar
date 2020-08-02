package racingcar.controller

import racingcar.model.Car
import racingcar.model.Participant
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (racingCarNames, tryCounts) = InputView.requestRacingCarNames() to InputView.requestTryCount()
    val participant = Participant(racingCarNames.map(::Car))

    startRacing(tryCounts, participant)
    showContents(racingCarNames, participant)
}

private fun showContents(racingCarNames: List<String>, participant: Participant) {
    ResultView.printRacingProcess(racingCarNames, participant.movingDistanceHistory)
    ResultView.printRacingWinner(participant)
}

private fun startRacing(tryCounts: Int, participant: Participant) {
    participant.play(tryCounts)
}
