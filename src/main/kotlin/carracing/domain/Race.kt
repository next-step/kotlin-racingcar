package carracing.domain

import carracing.dto.CarDTO

class Race(
    private val cars: List<Car>,
    private val attempts: Int,
    private val randomGenerator: RandomGenerator,
) {
    fun start(): List<List<CarDTO>> {
        val allRounds = mutableListOf<List<CarDTO>>()

        repeat(attempts) {
            moveCars()
            allRounds.add(cars.map { it.toDTO() })
        }

        return allRounds
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move(randomGenerator.generate())
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
