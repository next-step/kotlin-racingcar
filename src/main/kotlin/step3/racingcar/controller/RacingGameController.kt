package step3.racingcar.controller

import step3.racingcar.domain.condition.RandomCondition
import step3.racingcar.service.RacingGameService
import step3.racingcar.view.InputView
import step3.racingcar.view.Messages
import step3.racingcar.view.OutputView

class RacingGameController(
    private val racingGameService: RacingGameService
) {
    fun run() {
        OutputView.printMessage(Messages.MESSAGE_REQUEST_CAR_COUNT)
        val carCount = InputView.inputData()
        OutputView.printMessage(Messages.MESSAGE_ATTEMPT_COUNT)
        val attemptCount = InputView.inputData()
        OutputView.printMessage(Messages.MESSAGE_EXECUTION_RESULT)

        init(carCount, attemptCount)

        racingGameService.play()
    }

    private fun init(carCount: Int, attemptCount: Int) {
        racingGameService.initCars(carCount, RandomCondition())
        racingGameService.initAttemptCount(attemptCount)
    }
}
