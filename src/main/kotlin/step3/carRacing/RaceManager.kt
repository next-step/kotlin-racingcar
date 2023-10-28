package step3.carRacing

class RaceManager(private var dispatchHandler: DispatchHandler<Action, Payload>) {
    private var carCount: Int = 0
    private var tryCount: Int = 0

    init {
        dispatchHandler.subscribe(Action.FINISH_INPUT) { initState(it) }
    }

    private fun initState(payload: Payload) {
        if (payload is Payload.FinishInput) {
            carCount = payload.carCount
            tryCount = payload.tryCount
        }
        startRace()
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
