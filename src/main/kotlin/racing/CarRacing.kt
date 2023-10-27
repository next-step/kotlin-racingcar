package racing

import org.assertj.core.util.VisibleForTesting
import kotlin.random.Random

object CarRacing {
    @VisibleForTesting
    fun createCars(carCount: Int) = List(carCount) { Car() }

    fun race(tryCount: Int, carCount: Int): List<List<String>> {
        val cars = createCars(carCount)
        return List(tryCount) {
            cars.forEach { car ->
                val isMove = isMove { random(0..9) }
                if (isMove) {
                    car.move()
                }
            }
            cars.map { it.getResult() }
        }
    }

    @VisibleForTesting
    fun random(range: IntRange) = Random.nextInt(range.first, range.last)

    @VisibleForTesting
    fun isMove(intSupplier: () -> Int) = intSupplier() >= 4
}
