package step3.carRacing.contoller

import step3.carRacing.Action
import step3.carRacing.CarGenerator
import step3.carRacing.DispatchHandler
import step3.carRacing.Payload

class RaceController(private var dispatchHandler: DispatchHandler<Action, Payload>) {
    private var carCount: Int = 0
    private var tryCount: Int = 0

    init {
        dispatchHandler.subscribe(Action.FINISH_INPUT) { payload ->
            if (payload is Payload.FinishInput) {
                changeState(
                    carCount = payload.carCount,
                    tryCount = payload.tryCount
                )
                startRace()
            }
        }
    }

    private fun changeState(carCount: Int, tryCount: Int) {
        this.carCount = carCount
        this.tryCount = tryCount
    }

    private fun startRace() {
        val cars = CarGenerator.generate(carCount)
        for (i in 0 until tryCount) {
            for (car in cars) {
                car.tryRace()
            }
            dispatchHandler.dispatch(Action.FINISH_RACE, Payload.FinishRace(cars, i + 1))
            Thread.sleep(1000)
        }
    }
}
