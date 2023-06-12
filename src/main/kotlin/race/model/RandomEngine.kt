package race.model

import kotlin.random.Random

class RandomEngine : Engine {
    override fun cycle() = Random.nextInt(CYCLE_RANGE)

    companion object {
        const val CYCLE_RANGE = 10
    }
}
