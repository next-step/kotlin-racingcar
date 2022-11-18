package racingcar

import java.security.SecureRandom

private const val MAXIMUM_BOUND = 10

class RacingCar(private val cars: List<Car>, private val tryCount: Int) {
    constructor(carCount: Int, tryCount: Int) : this((0..carCount).map { Car() }, tryCount)

    fun start(): List<Car> {
        for (i in 0 until tryCount) {
            moveCars()
        }
        return cars
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move(SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND))
        }
    }
}
