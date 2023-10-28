package step3.carRacing.contoller

import step3.carRacing.model.Car
import step3.carRacing.view.OutputView
import kotlin.random.Random

class RaceController {
    private fun tryRound(cars: List<Car>) {
        for (car in cars) {
            car.tryRace(Random.nextInt(0, 10))
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
