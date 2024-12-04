package racing.controller

import racing.view.input.InputView
import racing.view.result.ResultView

object RacingControllerFactory {
    fun newInstance(
        inputView: InputView,
        resultView: ResultView,
    ): RacingController {
        return RacingControllerImpl(inputView, resultView)
    }
}
