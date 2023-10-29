package step3.carRacing.model

import step3.carRacing.view.OutputView
import step3.carRacing.view.SystemPrint
import kotlin.random.Random

class RaceOrganizer(private val cars: List<Car>) {

    private fun tryRound(cars: List<Car>) {
        this.cars.forEach { it.tryRace(Random.nextInt(0, 10)) }
    }

    fun startRace(tryCount: Int) {
        for (i in 0 until tryCount) {
            tryRound(cars)
            OutputView.renderRace(i, cars, SystemPrint())
            Thread.sleep(1000)
        }
    }
}
