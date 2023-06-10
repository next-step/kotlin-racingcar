package next.step.racing.service

import kotlin.random.Random

typealias DrivingStrategy = () -> Int
typealias RandomAlgorithm = () -> Int

object DrivingStrategyUtil {

    fun random(randomAlgorithm: RandomAlgorithm): DrivingStrategy {
        return {
            if (randomAlgorithm() >= 4) 1 else 0
        }
    }

    fun defaultRandom(): DrivingStrategy {
        return random { Random.nextInt(0, 10) }
    }
}
