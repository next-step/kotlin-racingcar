package racingcar_winner.model

import racingcar_winner.`interface`.RandomNumberBehavior
import kotlin.random.Random

const val MAX_RANDOM_NUMBER = 9
const val MIN_RANDOM_NUMBER = 0

class RandomNumberFactory : RandomNumberBehavior {
    override fun generateRandomNumber(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
