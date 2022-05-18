package racing.infra

import racing.domain.Car
import racing.domain.CarMovingStepper
import java.util.Random

class RandomCarMovingStepper : CarMovingStepper {
    override fun step(cars: List<Car>) {
        cars.forEach {
            if (random.nextInt(MAX_BOUND) >= FORWARD_NUMBER) {
                it.movePosition()
            }
        }
    }

    companion object {
        const val FORWARD_NUMBER: Int = 4
        const val MAX_BOUND: Int = 10
        private val random = Random()
    }
}
