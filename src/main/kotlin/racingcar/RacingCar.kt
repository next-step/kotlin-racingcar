package racingcar

import java.security.SecureRandom

private const val MAXIMUM_BOUND = 10

class RacingCar(carCount: Int, private val tryCount: Int, private val moveCarListener: (Car) -> Unit) {

    private val carList: List<Car>

    init {
        carList = ArrayList<Car>().apply {
            for (i in 0 until carCount) {
                add(Car())
            }
        }
    }

    fun start() {
        for (i in 0 until tryCount) {
            moveCars()
        }
    }

    private fun moveCars() {
        for (car in carList) {
            car.move(SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND))
            moveCarListener(car)
        }
    }
}
