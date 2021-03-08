package race.domain

import race.ui.ResultView
import kotlin.random.Random

class Race(carCount: Int, private val lapCount: Int) {
    val cars: List<Car> = IntRange(1, carCount).map { Car() }

    init {
        require(carCount > 0) { "car count is positive." }
        require(lapCount > 0) { "lap count is positive." }
    }

    private fun turnAround() {
        cars.map { it.move(Random.nextInt(0, 9)) }
        ResultView.printNow(cars)
        println()
    }

    fun start() {
        ResultView.printTitle()
        IntRange(1, lapCount).forEach { _ -> turnAround() }
    }
}
