package carracing.domain

import carracing.strategy.RandomGenerator
import carracing.ui.ResultView

class Race(
    private val cars: List<Car>,
    private val attempts: Int,
    private val randomGenerator: RandomGenerator,
) {
    fun start() {
        repeat(attempts) {
            cars.forEach { car ->
                val randomValue = randomGenerator.generate()
                (randomValue >= 4).let { if (it) car.move() }
            }
            ResultView.printCurrentPosition(cars)
        }
    }
}
