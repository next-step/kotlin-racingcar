package next.step.racing.util

import next.step.racing.domain.car.DrivingStrategy
import kotlin.random.Random

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
