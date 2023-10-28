package step3.carRacing.view

import step3.carRacing.Action
import step3.carRacing.Car
import step3.carRacing.DispatchHandler
import step3.carRacing.Payload

class OutputView(private val dispatchHandler: DispatchHandler<Action, Payload>) {
    init {
        dispatchHandler.subscribe(Action.FINISH_RACE) { renderRace(it) }
    }

    private fun renderRace(payload: Payload) {
        if (payload is Payload.FinishRace) {
            println("<-------------- ${payload.round} Round Race 🏎️ -------------->")
            for (car in payload.cars) {
                renderCarPosition(car)
            }
        }
    }

    private fun renderCarPosition(car: Car) {
        for (position in 0 until car.curPosition) {
            print('-')
        }
        print("\n")
    }
}
