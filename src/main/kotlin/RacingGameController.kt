package step3.racingcar.controller

import view.InputView
import view.RacingGameInput
import view.ResultView

class RacingGameController {
    private val service: RacingGameService = RacingGameService()
    private val resultView: ResultView = ResultView()

    fun main() {
        startGame(InputView.executeInputScreen())
    }

    private fun startGame(input: RacingGameInput) {
        service.race(input).let {
            resultView.outputScreen(it)
        }
    }
}