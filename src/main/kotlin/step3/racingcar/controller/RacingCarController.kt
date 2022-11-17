package step3.racingcar.controller

import step3.racingcar.service.RacingCarService
import step3.racingcar.view.InputView.Companion.inputCarCountGuideMessagePrinter
import step3.racingcar.view.InputView.Companion.inputRoundCountGuideMessagePrinter

class RacingCarController {
    private val racingCarService: RacingCarService = RacingCarService()

    fun gameStart() {
        val carCount = inputCarCountGuideMessagePrinter()
        val roundCount = inputRoundCountGuideMessagePrinter()
        racingCarService.play(carCount, roundCount)
    }
}
