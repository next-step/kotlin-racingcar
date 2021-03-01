package car.business

import kotlin.random.Random
import kotlin.streams.toList

class Cars(amount: Int, random: Random = Random) {
    private val RANDOM_MAX_SIZE = 10

    private val cars: List<Car>
    private val random: Random

    init {
        cars = ArrayList(amount)
        for (i in 0 until amount) {
            cars.add(Car())
        }
        this.random = random
    }

    fun move(): Int {
        return cars.stream()
            .map { it.move(random.nextInt(RANDOM_MAX_SIZE)) }
            .filter { it }
            .count()
            .toInt()
    }

    fun getPositions(): List<Int> {
        return cars.stream()
            .map { it.position }
            .toList()
    }
}
