package next.step.racing.service

import kotlin.random.Random

object DrivingStrategyUtil {

    fun random(randomAlgorithm: () -> Int): () -> Int {
        return {
            if (randomAlgorithm() >= 4) 1 else 0
        }
    }

    fun defaultRandom(): () -> Int {
        return random { Random.nextInt(0, 10) }
    }
}
