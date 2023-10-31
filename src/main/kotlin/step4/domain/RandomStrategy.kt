package step4.domain

import java.util.Random

class RandomStrategy : MoveStrategy {
    override val count: Int
        get() = Random().nextInt(10)

    override fun isMoveSuccess(): Boolean {
        return count >= 4
    }
}
