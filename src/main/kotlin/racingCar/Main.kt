package racingCar

import racingCar.domain.RacingCars
import racingCar.domain.Winner
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    // 자동차 경주 참여자 및 경주횟수 입력
    val carParticipants = InputView.getCarName()
    val trialCount = InputView.getTrialCount()

    // 경주
    val racing = RacingCars(carParticipants)
    val resultRacing = racing.startRacing(trialCount)

    // 결과
    val returnWinner = Winner.getRacingWinner(resultRacing)
    OutputView.getCarRacingWinners(returnWinner)
}
