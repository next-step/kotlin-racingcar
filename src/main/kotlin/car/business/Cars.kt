package car.business

import kotlin.random.Random

class Cars(amount: Int, random: Random = Random) {

    private val cars: List<Car> = (1..amount).map { Car() }
    private val random: Random = random

    fun move(): Int {
        return cars.count { it.move(random.nextInt(RANDOM_MAX_SIZE)) }
    }

    fun getPositions(): List<Int> {
        return cars.map { it.currentPosition }
    }

    companion object {
        val RANDOM_MAX_SIZE = 10
    }
}
