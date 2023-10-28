package step3.carRacing.model

import step3.carRacing.Action
import step3.carRacing.DispatchHandler
import step3.carRacing.Payload
import step3.carRacing.contoller.RaceController
import step3.carRacing.view.InputView
import step3.carRacing.view.OutputView

class CarRacing {
    private val dispatchHandler = DispatchHandler<Action, Payload>()
    private val inputView = InputView(dispatchHandler)

    init {
        RaceController(dispatchHandler)
        OutputView(dispatchHandler)
    }

    fun start() {
        inputView.start()
    }
}
