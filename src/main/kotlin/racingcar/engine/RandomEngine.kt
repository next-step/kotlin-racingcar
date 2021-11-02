package racingcar.engine

import racingcar.car.Car
import racingcar.util.Validation
import java.util.Random

class RandomEngine : Engine {
    private val random = Random()

    override fun forward(distance: Int): Int {
        val num = random.nextInt(Validation.MAX_CONDITION)
        return if (Validation.isMatchStartCondition(num)) {
            distance + Car.ONE_SPACE
        } else {
            distance
        }
    }
}
