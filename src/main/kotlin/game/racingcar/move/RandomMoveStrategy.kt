package game.racingcar.move

import kotlin.random.Random

class RandomMoveStrategy : MoveStrategy {
    override fun movable(): Boolean {
        return Random.nextInt(10) >= 4
    }
}
