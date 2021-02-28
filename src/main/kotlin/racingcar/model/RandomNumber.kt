package racingcar.model

import racingcar.Constants.MAX_RANDOM_NUMBER
import racingcar.Constants.MIN_RANDOM_NUMBER
import racingcar.`interface`.RandomNumberBehavior
import kotlin.random.Random

class RandomNumber : RandomNumberBehavior {
    override fun generateRandomNumber(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
