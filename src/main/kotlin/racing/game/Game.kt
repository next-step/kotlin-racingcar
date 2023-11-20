package racing.game

import racing.car.Car
import racing.generator.NumberGenerator

class Game(
    private val cars: List<Car>
) {
    fun run(numberGenerator: NumberGenerator): List<Car> {
        cars.forEach { car ->
            car.move(numberGenerator.generate(RANDOM_LIMIT))
        }

        return cars
    }

    fun end(): List<String> {
        val maxScore = cars.maxBy { it.position }.position
        val winners = cars.filter { it.position == maxScore }
        return winners.map { it.name }
    }

    companion object {
        private const val RANDOM_LIMIT = 10
    }
}
