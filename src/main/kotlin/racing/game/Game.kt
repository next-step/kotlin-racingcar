package racing.game

import racing.car.Car

class Game(
    private val cars: List<Car>
) {
    fun run(conditions: List<Int>): List<Car> {
        cars.forEachIndexed { idx, car ->
            car.move(conditions[idx])
        }
        return cars
    }

    fun end(): List<String> {
        val maxScore = cars.maxBy { it.position }.position
        val winners = cars.filter { it.position == maxScore }
        return winners.map { it.name }
    }
}
