package racing.infra

import racing.domain.Car
import racing.domain.MovingRule
import java.util.Random

class RandomMovingRule : MovingRule {
    companion object {
        private val random = Random()
    }

    override fun goForward(car: List<Car>): List<Car> {
        return car.asSequence()
            .map {
                if (random.nextInt(10) >= 4) {
                    it.movePosition()
                } else {
                    it
                }
            }
            .toList()
    }
}
