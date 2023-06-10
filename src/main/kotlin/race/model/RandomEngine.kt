package race.model

import kotlin.random.Random

class RandomEngine : Engine {
    override fun create() = Random.nextInt(MOVE_RANGE)

    companion object {
        const val MOVE_RANGE = 10
    }
}
