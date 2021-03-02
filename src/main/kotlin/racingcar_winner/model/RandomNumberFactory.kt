package racingcar_winner

import racingcar_winner.`interface`.RandomNumberBehavior
import kotlin.random.Random

class RandomNumberFactory : RandomNumberBehavior {
    override fun generateRandomNumber(): Int {
        return Random.nextInt(0, 9)
    }
}
