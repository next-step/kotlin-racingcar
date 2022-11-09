package step3.racingcar.controller

import step3.racingcar.service.RacingCarService
import step3.racingcar.view.InputView.Companion.inputCarCountGuideMessagePrinter
import step3.racingcar.view.InputView.Companion.inputRoundCountGuideMessagePrinter
import step3.racingcar.view.ResultView

class RacingCarController {
    private val racingCarService: RacingCarService = RacingCarService()

    fun gameStart() {
        val carCount = inputCarCountGuideMessagePrinter()
        val roundCount = inputRoundCountGuideMessagePrinter()
        val playResult = racingCarService.play(carCount, roundCount)
        ResultView.printResult(roundCount, playResult)
    }
}
