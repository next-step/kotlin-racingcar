package racingCar

import racingCar.domain.RacingCar
import racingCar.domain.Winner
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val carNames = InputView.getCarName()
    val trialCount = InputView.getTrialCount()
    val racing = RacingCar(carNames)
    val resultRacingCar = racing.run { racing.carMove(trialCount) }
    val returnWinner = Winner.getRacingWinner(resultRacingCar)
    OutputView.getCarRacingWinners(returnWinner)
}
