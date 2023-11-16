package racing

import kotlin.random.Random

class Game(
    private val cars: List<Car>
) {
    fun run(): List<Car> {
        cars.forEach {
            it.move(Random.nextInt(RANDOM_LIMIT))
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
