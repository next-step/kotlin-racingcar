package racingcar

import kotlin.random.Random

class RandomMoveStrategy: MoveStrategy {
    override fun move(): Int = Random.nextInt(Cars.RANDOM_RANGE)
}
