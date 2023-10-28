package racingcar.strategy

import kotlin.random.Random

class RandomNumberMovingStrategy: MovingStrategy {
    override fun canMove(): Boolean {
        val randomInt = Random.nextInt(10)
        return randomInt >= 4
    }
}
