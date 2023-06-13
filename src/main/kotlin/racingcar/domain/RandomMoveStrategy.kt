package racingcar.domain

import java.util.Random

class RandomMoveStrategy : MoveStrategy {
    private val random = Random()
    override fun isMovable(): Boolean = random.nextInt(10) > BASE

    companion object {
        const val BASE = 4
    }
}
