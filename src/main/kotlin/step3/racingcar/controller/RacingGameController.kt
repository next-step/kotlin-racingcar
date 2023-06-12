package step3.racingcar.controller

import step3.racingcar.domain.condition.RandomCondition
import step3.racingcar.service.RacingGameService
import step3.racingcar.view.InputView
import step3.racingcar.view.OutputView

class RacingGameController(
    private val racingGameService: RacingGameService
) {
    fun run() {
        OutputView.printRequestCarCount()
        val carCount = InputView.inputData()
        OutputView.printRequestAttemptCount()
        val attemptCount = InputView.inputData()
        OutputView.printExecutionResult()

        init(carCount, attemptCount)

        racingGameService.play()
    }

    private fun init(carCount: Int, attemptCount: Int) {
        racingGameService.initCars(carCount, RandomCondition)
        racingGameService.initRound(attemptCount)
    }
}
