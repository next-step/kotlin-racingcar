package carracing.domain

import kotlin.random.Random

class RandomStrategy : MoveStrategy {

    override fun isMovable(): Boolean {
        if (makeRandomNumber() >= 4) {
            return true
        }
        return false
    }

    private fun makeRandomNumber(): Int {
        return Random.nextInt(MAX_SIZE)
    }

    companion object {
        const val MAX_SIZE: Int = 9
    }
}
