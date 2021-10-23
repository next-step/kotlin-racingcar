package racingcar.engine

import racingcar.constant.Constant
import racingcar.util.CarValidation
import java.util.Random

class RandomEngine : Engine {
    private val random = Random()

    override fun forward(distance: String): String {
        val num = random.nextInt(CarValidation.MAX_CONDITION)
        return if (CarValidation.isMatchCondition(num)) {
            distance.plus(Constant.ONE_SPACE)
        } else {
            distance
        }
    }
}
