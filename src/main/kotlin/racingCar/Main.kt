package racingCar

import racingCar.domain.RacingCars
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    // 자동차 경주 참여자 및 경주횟수 입력
    val carParticipant = InputView.getCarName()
    val trialCount = InputView.getTrialCount()

    // 경주
    val racing = RacingCars()
    racing.generateCar(carParticipant)
    val resultRacing = racing.startRacing(trialCount)

    val returnWinner = racing.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
