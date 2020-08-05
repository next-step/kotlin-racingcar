package racingCar

import racingCar.domain.RacingCars
import racingCar.domain.Winner
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val carNames = InputView.getCarName()
    val trialCount = InputView.getTrialCount()

    val participants = RacingCars(carNames)
    val resultRacing = participants.run { participants.startRacing(trialCount) }

    val returnWinner = Winner.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
