package racingcar

import java.security.SecureRandom

private const val MAXIMUM_BOUND = 10

class RacingCar private constructor(private val cars: List<Car>, private val tryCount: Int, private val carHistory: HashMap<Car, ArrayList<Int>> = HashMap()) {
    constructor(carCount: Int, tryCount: Int) : this((0 until carCount).map { Car() }, tryCount)

    fun start(): HashMap<Car, ArrayList<Int>> {
        for (i in 0 until tryCount) {
            moveCars()
        }
        return carHistory
    }

    private fun moveCars() {
        cars.forEach { car ->
            val carHistoryItem = carHistory[car] ?: ArrayList<Int>().apply {
                carHistory[car] = this
            }

            carHistoryItem.add(car.move(SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND)))
        }
    }
}
