package racingCar

import racingCar.domain.RacingCars
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val inputNames = InputView.getCarName()
    val carParticipant = InputView.splitNames(inputNames)
    val trialCount = InputView.getTrialCount()

    val racing = RacingCars(carParticipant)
    val resultRacing = racing.run { racing.startRacing(trialCount) }

    val returnWinner = racing.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
