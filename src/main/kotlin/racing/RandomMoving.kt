package racing

import kotlin.random.Random

object RandomMoving : Movable {
    private const val MIN_BOUND = 0
    private const val MAX_BOUND = 9
    private const val MIN_MOVABLE_VALUE = 4

    override fun canMove(): Boolean {
        val randomValue = Random.nextInt(MAX_BOUND) + MIN_BOUND
        return randomValue >= MIN_MOVABLE_VALUE
    }
}
