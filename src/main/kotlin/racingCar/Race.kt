package racingCar

import java.util.Random

class Race(private val carCount: Int, private val tryCount: Int) {
    val carPositions = mutableListOf<Int>()
    private val cars: List<Car> = (1..this.carCount).map { Car() }

    fun run() {
        for (i in 1..tryCount) {
            cars.forEach {
                it.moveFor(Random().nextInt(10))
                carPositions.add(it.position)
            }
        }
    }
}
