package racingCar

import java.util.Random

class Race(private val carCount: Int, private val tryCount: Int) {
    val carPositions = mutableListOf<Int>()
    private val cars = mutableListOf<Car>()

    init {
        for (i: Int in 1..this.carCount) cars.add(Car())
    }

    fun run() {
        cars.forEach {
            it.moveFor(tryCount, Random().nextInt(10))
            carPositions.add(it.position)
        }
    }
}
