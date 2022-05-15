package racing.infra

import racing.domain.Car
import racing.domain.CarMovingStepper
import java.util.Random

class RandomCarMovingStepper : CarMovingStepper {
    companion object {
        private val random = Random()
    }

    override fun step(cars: List<Car>): List<Car> {
        return cars.map {
            if (random.nextInt(10) >= 4) {
                it.movePosition()
            } else {
                Car(it.position)
            }
        }
    }
}
