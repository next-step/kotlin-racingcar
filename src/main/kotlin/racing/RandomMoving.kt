package racing

import kotlin.random.Random

class RandomMoving : Movable {
    override fun canMove(): Boolean {
        val randomValue = Random.nextInt(MAX_BOUND) + MIN_BOUND
        return randomValue >= MIN_MOVABLE_VALUE
    }

    companion object {
        const val MIN_BOUND = 0
        const val MAX_BOUND = 9
        const val MIN_MOVABLE_VALUE = 4
    }
}
