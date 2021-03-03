package racingcar

import kotlin.random.Random

class RandomForceGenerator : ForceGenerator {
    private val random: Random = Random

    override fun generate(): Force {
        return Force(random.nextInt(from = 0, until = 10))
    }
}
