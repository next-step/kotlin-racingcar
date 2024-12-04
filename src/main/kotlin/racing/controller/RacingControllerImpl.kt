package racing.controller

import racing.model.CarFactory
import racing.model.RacingTrack
import racing.view.input.InputView
import racing.view.result.ResultView

class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
) : RacingController {
    override fun start() {
        displayCarNamesQuestion()
        val carNames = inputView.inputCarNames()
        displayAttemptCountQuestion()
        val attemptCount = inputView.inputAttemptCount()
        val racingCars = CarFactory.createCars(carNames)
        val racingTrack = RacingTrack(racingCars = racingCars, attemptCount = attemptCount)

        resultView.printOutputTitle()
        racingTrack.startRound {
            resultView.displayCarMovement(racingCars)
        }

        val winner = racingCars.getRaceWinners()
        resultView.displayRaceWinners(winner)
    }

    private fun displayCarNamesQuestion() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    private fun displayAttemptCountQuestion() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
