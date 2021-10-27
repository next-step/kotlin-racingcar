package racingcar.engine

import racingcar.constant.Constant
import racingcar.util.Validation
import java.util.Random

class RandomEngine : Engine {
    private val random = Random()

    override fun forward(distance: String): String {
        val num = random.nextInt(Validation.MAX_CONDITION)
        return if (Validation.isMatchCondition(num)) {
            distance.plus(Constant.ONE_SPACE)
        } else {
            distance
        }
    }
}
