package racing.domain

import kotlin.random.Random
import kotlin.random.nextInt

class RacingCar(
    val id: RacingCarId,
) {
    var position: Int = 0
        private set

    companion object {
        private const val THRESHOLD = 4
        val RANDOM_RANGE = 0..9
    }

    fun moveForward() {
        val random = Random.nextInt(RANDOM_RANGE)
        if (random >= THRESHOLD) {
            position++
        }
    }
}

@JvmInline
value class RacingCarId(
    val value: String
)
