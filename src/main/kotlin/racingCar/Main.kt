package racingCar

import racingCar.domain.RacingCars
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val carNames = InputView.getCarName()
    val trialCount = InputView.getTrialCount()

    val racing = RacingCars(carNames)
    val resultRacing = racing.run { racing.startRacing(trialCount) }

    val returnWinner = racing.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
