package racingCar

import racingCar.domain.RacingCar
import racingCar.domain.Winner
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val carNames = InputView.getCarName()
    val trialCount = InputView.getTrialCount()

    val racingCars = RacingCar(carNames)
    val resultRacing = racingCars.run { racingCars.startRacing(trialCount) }

    val returnWinner = Winner.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
