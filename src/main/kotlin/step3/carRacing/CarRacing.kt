package step3.carRacing

import step3.carRacing.view.InputView
import step3.carRacing.view.OutputView

class CarRacing {
    private val dispatchHandler = DispatchHandler<Action, Payload>()
    private val inputView = InputView(dispatchHandler)

    init {
        RaceManager(dispatchHandler)
        OutputView(dispatchHandler)
    }

    fun start() {
        inputView.start()
    }
}
