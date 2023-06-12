package race.domain

import kotlin.random.Random

class RandomMoveCondition : MoveCondition {
    override fun canGoStraight(): Boolean {
        return 4 <= Random.nextInt(10)
    }
}
