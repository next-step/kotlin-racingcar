package step3.carRacing.contoller

import step3.carRacing.Car
import step3.carRacing.view.OutputView

class RaceController {
    private fun tryRound(cars: List<Car>) {
        for (car in cars) {
            car.tryRace()
        }
    }

    fun startRace(tryCount: Int, cars: List<Car>) {
        for (i in 0 until tryCount) {
            tryRound(cars)
            OutputView.renderRace(i, cars)
            Thread.sleep(1000)
        }

    }
}
