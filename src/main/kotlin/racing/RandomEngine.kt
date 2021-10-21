package racing

import kotlin.random.Random
import kotlin.random.nextInt

object RandomEngine : Engine {

    private const val MOVING_THRESHOLD = 4

    private val random = Random.Default
    private val movingRange = (0..9)

    override fun canMove(): Boolean {
        return random.nextInt(movingRange) >= MOVING_THRESHOLD
    }
}
